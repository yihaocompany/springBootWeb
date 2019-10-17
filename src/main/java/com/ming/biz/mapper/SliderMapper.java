package com.ming.biz.mapper;

import com.ming.biz.model.Slider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wellfuture
 * @Date: 2019/5/16 17:12
 * Describe:
 */
@Repository
@Mapper
public interface SliderMapper {

    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, statementType = StatementType.STATEMENT,resultType=int.class)
    @Insert("insert into sliders (title,url,picurl) values(#{title},#{url},#{picurl})")
    int addSlider(Slider slider);

    @Update("update sliders set title=#{Slider.title},url=#{Slider.url} ,picurl=#{Slider.picurl}where id=#{id}")
    void updateSlider(@Param("Slider") Slider slider, @Param("id") int id);

    @Select("select * from sliders")
    List<Slider> getAllSlider();

    @Select("select * from sliders where id=#{WebConfig.id} ")
    Slider getSliderbyId(@Param("id") int id);

    @Delete("delete from sliders where id=#{id}")
    void deleteSlider(int id);

    @Select("select * from sliders where picurl=#{WebConfig.picurl} ")
    int getSliderbyPic(@Param("picurl") String picurl);

}
