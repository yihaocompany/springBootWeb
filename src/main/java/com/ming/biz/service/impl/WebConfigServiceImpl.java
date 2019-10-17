package com.ming.biz.service.impl;

import com.ming.biz.mapper.WebConfigMapper;
import com.ming.biz.model.Result;
import com.ming.biz.model.WebConfig;
import com.ming.biz.service.WebConfigService;
import com.ming.biz.utils.ResultUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wellfuture
 * @Date: 2019/5/16 17:09
 * Describe:
 */
@Service
@CacheConfig(cacheNames = "config")

public class WebConfigServiceImpl implements WebConfigService,Serializable {

    @Autowired
    WebConfigMapper webConfigMapper;

    @Override
    public Result addWebConfig(WebConfig webConfig) {
        int id = webConfigMapper.getWebConfigByKey(webConfig.getWeb_key());
        try {
            if(id == 0){
                webConfigMapper.addWebConfig(webConfig);
                return ResultUtil.success(200, webConfig.getId(), "添加Key成功!");
            } else {
                return ResultUtil.success(201, id, "该Key已存在!");
            }
        } catch (Exception e){
            return ResultUtil.error(500, "更新Key失败!");
        }
    }


    @Override
/*    @Cacheable(cacheNames = {"allconfig"})*/
    public JSONArray getAllWebConfig() {
        List<WebConfig> links = webConfigMapper.getAllWebConfig();
        return JSONArray.fromObject(links);
    }

    @Override
    public Result updateWebConfig(WebConfig webConfig, int id) {
        try {
            webConfigMapper.updateWebConfig(webConfig, id);
            return ResultUtil.success(202, id, "更新友链成功!");
        } catch (Exception e){
            return ResultUtil.error(500, "更新友链失败!");
        }
    }

    @Override
    public Result deleteWebConfig(int id) {
        try {
            webConfigMapper.deleteWebConfig(id);
            return ResultUtil.success("删除友链成功!");
        } catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500, "删除友链失败!");
        }
    }

    @Override
    public Result getWebConfig() {
        return ResultUtil.success(getListWebConfig(), "success");
    }
    @Override
    @Cacheable(value = "user", key = "targetClass + ':' + methodName + '_' + #p0", unless = "#result.size() <= 0")
    public   List<WebConfig> getListWebConfig(){
        List<WebConfig> webconfigs = webConfigMapper.getAllWebConfig();
        return  webconfigs;
    }
}


