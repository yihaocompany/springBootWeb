package com.ming.biz.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ming.biz.component.PhoneRandomBuilder;

import com.ming.biz.model.User;
import com.ming.biz.redis.StringRedisServiceImpl;
import com.ming.biz.service.UserService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @author: wellfuture
 * @Date: 2018/6/4 15:03
 * Describe: 注册获得手机验证码
 */
@Controller
public class GetPhoneCodeControl {


    @Autowired
    StringRedisServiceImpl stringRedisService;
    @Autowired
    UserService userService;
    private static final String REGISTER = "register";

    @PostMapping("/getCode")
    @ResponseBody
    public int getAuthCode(HttpServletRequest request){

        String phone = request.getParameter("phone");
        String sign = request.getParameter("sign");


        if(REGISTER.equals(sign)){
            if(userService.findUserByPhone(phone)!=null){
                return 2;
            }
        }


        String trueMsgCode = PhoneRandomBuilder.randomBuilder();
        System.out.println("验证手机号：" + trueMsgCode);

//        在redis中保存手机号验证码并设置过期时间
        stringRedisService.set(phone, trueMsgCode);
        stringRedisService.expire(phone, 300);

        String msgCode = "SMS_136394413";
        if(REGISTER.equals(sign)){
            msgCode = "SMS_174812316";
        }

        else {
            //改密码的短信模板
            msgCode= "SMS_174812456";
        }

        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = sendSmsResponse(phone, trueMsgCode, msgCode);
        } catch (ClientException e) {
            e.printStackTrace();
            return 0;
        }

        return 1;
    }



    private static SendSmsResponse sendSmsResponse(String phoneNumber, String code, String msgCode) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //"***"分别填写自己的AccessKey ID和Secret
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FrDm3feop8SuNuRtsJU", "mbL6XkVnUiOarw54gtpozT2mitBPgR");
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        //填写接收方的手机号码
        request.setPhoneNumbers(phoneNumber);
        //此处填写已申请的短信签名
        request.setSignName("易好开发");
        //此处填写获得的短信模版CODE
        request.setTemplateCode(msgCode);
        //笔者的短信模版中有${code}, 因此此处对应填写验证码
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

}
