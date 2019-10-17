package com.ming.biz.service;

import com.ming.biz.model.Result;
import com.ming.biz.model.Slider;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * @author: wellfuture
 * @Date: 2018/7/18 12:07
 * Describe: 归档业务操作
 */
public interface SliderService {


    Result addSlider(Slider slider);
    JSONArray getAllJosnSlider();
    Result updateSlider(Slider slider, int id);
    Result deleteSlider(int id);
    Slider getSliderbyId(int id);
    List<Slider> getListSliders();
    Result getAllSliders();
    int getSliderbyPic(String picurl);

}
  /*  @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, statementType = StatementType.STATEMENT,resultType=int.class)
    @Insert("insert into sliders (title,url,picurl) values(#{title},#{url},#{picurl})")
    int addSlider(Slider slider);

    @Update("update sliders set title=#{Slider.title},url=#{Slider.url} ,picurl=#{Slider.picurl}where id=#{id}")
    void updateSlider(@Param("Slider") Slider slider, @Param("id") int id);

    @Select("select * from sliders")
    List<Slider> getAllSlider();

    @Select("select * from sliders where id=#{WebConfig.id} ")
    int getSliderbyId(@Param("id") String key);

    @Delete("delete from sliders where id=#{id}")
    void deleteSlider(int id);

    @Select("select * from sliders where picurl=#{WebConfig.picurl} ")
    int getSliderbyPic(@Param("picurl") String picurl);*/