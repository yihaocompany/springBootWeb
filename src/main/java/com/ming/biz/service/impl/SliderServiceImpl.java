package com.ming.biz.service.impl;


import com.ming.biz.mapper.SliderMapper;
import com.ming.biz.model.Result;
import com.ming.biz.model.Slider;
import com.ming.biz.service.SliderService;
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

public class SliderServiceImpl implements SliderService,Serializable {

/*
    Result addSlider(Slider slider);
    JSONArray getAllJosnSlidder();
    Result updateSlider(Slider slider, int id);
    Result deleteSlider(int id);
    Slider getSliderbyId();
    List<Slider> getListSliders();
    Result getAllSliders();
    int getSliderbyPic(String picurl);
    */

    @Autowired
    SliderMapper sliderMapper;

    @Override
    public Result addSlider(Slider slider) {
        int id = sliderMapper.getSliderbyPic(slider.getPicurl());
        try {
            if(id == 0){
                sliderMapper.addSlider(slider);
                return ResultUtil.success(200, slider.getId(), "添加图片成功!");
            } else {
                return ResultUtil.success(201, id, "该图片已存在!");
            }
        } catch (Exception e){
            return ResultUtil.error(500, "更新图片失败!");
        }
    }


    @Override
    public JSONArray getAllJosnSlider() {
        List<Slider> links = sliderMapper.getAllSlider();
        return JSONArray.fromObject(links);
    }

    @Override
    public Result updateSlider(Slider slider, int id) {
        try {
            sliderMapper.updateSlider(slider, id);
            return ResultUtil.success(202, id, "更新图片成功!");
        } catch (Exception e){
            return ResultUtil.error(500, "更新图片失败!");
        }
    }

    @Override
    public Result deleteSlider(int id) {
        try {
            sliderMapper.deleteSlider(id);
            return ResultUtil.success("删除图片成功!");
        } catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500, "删除图片失败!");
        }
    }

    @Override
    public Result getAllSliders() {
        return ResultUtil.success(getListSliders(), "success");
    }
    @Override
    @Cacheable(value = "user", key = "targetClass + ':' + methodName + '_' + #p0", unless = "#result.size() <= 0")
    public   List<Slider> getListSliders(){
        List<Slider> sliders = sliderMapper.getAllSlider();
        return  sliders;
    }

    @Override
    public Slider getSliderbyId(int id){
        return sliderMapper.getSliderbyId(id);
    }

    @Override
    public int getSliderbyPic(String picurl){
        return sliderMapper.getSliderbyPic(picurl);
    }

}


