package com.ming.biz.controller;

import com.ming.biz.model.Result;

import com.ming.biz.model.WebConfig;
import com.ming.biz.redis.StringRedisServiceImpl;
import com.ming.biz.service.WebConfigService;
import com.ming.biz.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: wellfuture
 * @Date: 2019/5/19 17:04
 * Describe: 友链页面
 */
@RestController
public class WebConfigController {

    @Autowired
    WebConfigService webConfigService;
    @Autowired
    StringRedisServiceImpl stringRedisService;
    @GetMapping("/getWebConfig")
     Result configs(Model configs){
        for (WebConfig code : webConfigService.getListWebConfig()) {
            configs.addAttribute(code.getWeb_key(), code.getWeb_value());
        }
       return  ResultUtil.success(configs, "success");
    }

}


