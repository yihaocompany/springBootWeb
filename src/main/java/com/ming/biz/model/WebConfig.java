package com.ming.biz.model;
import lombok.Data;

/**
 * @author: wellfuture
 * @Date: 2018/7/18 11:52
 * Describe: 文章归档
 */
@Data
public class WebConfig {

    private int id;
    private String web_key;
    private String web_type;
    private String web_value;

    public WebConfig() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeb_key() {
        return web_key;
    }

    public void setWeb_key(String web_key) {
        this.web_key = web_key;
    }

    public String getWeb_type() {
        return web_type;
    }

    public void setWeb_type(String web_type) {
        this.web_type = web_type;
    }

    public String getWeb_value() {
        return web_value;
    }

    public void setWeb_value(String web_value) {
        this.web_value = web_value;
    }
}
