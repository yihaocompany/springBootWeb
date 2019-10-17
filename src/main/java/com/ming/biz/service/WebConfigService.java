package com.ming.biz.service;

import com.ming.biz.model.Result;
import com.ming.biz.model.WebConfig;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @author: wellfuture
 * @Date: 2018/7/18 12:07
 * Describe: 归档业务操作
 */
public interface WebConfigService {


    Result addWebConfig(WebConfig webConfig);

    JSONArray getAllWebConfig();

    Result updateWebConfig(WebConfig webConfig, int id);

    Result deleteWebConfig(int id);

    Result getWebConfig();

    List<WebConfig> getListWebConfig();
}
