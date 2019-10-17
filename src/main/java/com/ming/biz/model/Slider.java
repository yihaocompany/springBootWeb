package com.ming.biz.model;

import lombok.Data;

/**
 * @author: wellfuture
 * @Date: 2018/7/18 11:52
 * Describe: 文章归档
 */
@Data
public class Slider {

    private int id;

    /**
     * 归档日期
     */
    private String url;
    private String title;
    private String picurl;
}
