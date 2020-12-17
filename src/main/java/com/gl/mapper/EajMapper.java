package com.gl.mapper;

import com.gl.entity.Eaj;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 
 * @author 郭亮
 * @date 2020/9/23 9:32 
 **/
public interface EajMapper {

    @Cacheable(cacheManager = "ehcacheJcache", value = "eaj", key = "#ahdm")
    @Select("SELECT AHDM,AH FROM EAJ WHERE AHDM=#{ahdm}")
    Eaj getEaj(@Param(value = "ahdm") String ahdm);

    @Insert("INSERT INTO EAJ(AHDM,AH,JZXH) VALUE(#{ahdm},#{ah},'3')")
    Integer insertEaj(Eaj recode);

    @Select("SELECT AHDM,AH FROM EAJ WHERE ND='2020' ORDER BY AHDM")
    List<Eaj> getEajByNd();
}
