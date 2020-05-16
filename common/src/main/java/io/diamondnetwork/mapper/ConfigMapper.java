package io.diamondnetwork.mapper;

import io.diamondnetwork.model.Config;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface ConfigMapper {

    @Options(useGeneratedKeys = true)
    @Insert("insert into t_config(conf_name,conf_value,comment)values(#{confName},#{confValue},#{comment})")
    int insertConfig(Config config);

    @Select("select * from t_config where conf_name=#{name}")
    Config getConfigByName(@Param("name") String name);

    /**
     * @return
     */
    @Transactional(propagation = Propagation.MANDATORY)
    @Select("select * from t_config where conf_name=#{name} for update")
    Config getConfigByNameForUpdate(@Param("name") String name);

    @Update("update t_config set conf_value=#{value} where conf_name=#{name}")
    int updateConfigValue(@Param("name") String name, @Param("value") String value);

    @Update("update t_config set conf_value=#{value}, comment=#{comment} where conf_name=#{name}")
    int updateConfigValueWithComment(@Param("name") String name, @Param("value") String value, @Param("comment") String comment);

    @Select("select * from t_config")
    List<Config> getConfigList();
}
