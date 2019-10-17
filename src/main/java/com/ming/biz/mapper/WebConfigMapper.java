package com.ming.biz.mapper;

import com.ming.biz.model.FriendLink;
import com.ming.biz.model.WebConfig;
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
public interface WebConfigMapper {

    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, statementType = StatementType.STATEMENT,resultType=int.class)
    @Insert("insert into web_config(web_key,web_type,web_value) values(#{web_key},#{web_type},#{web_value})")
    int addWebConfig(WebConfig webConfig);

    @Update("update web_config set web_key=#{WebConfig.web_key},web_type=#{WebConfig.web_type} ,web_value=#{WebConfig.web_value}where id=#{id}")
    void updateWebConfig(@Param("WebConfig") WebConfig webConfig, @Param("id") int id);

    @Select("select * from web_config")
    List<WebConfig> getAllWebConfig();

    @Select("select * from web_config where web_key=#{WebConfig.web_key} ")
    int getWebConfigByKey(@Param("key") String key);

    @Delete("delete from web_config where id=#{id}")
    void deleteWebConfig(int id);

}
