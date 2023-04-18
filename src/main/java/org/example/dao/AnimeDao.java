package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Anime;

import java.util.List;

public interface AnimeDao {
    //查询动漫全部信息
    List<Anime> selectAll(@Param("beginNum") int beginNum);

    //根据f_id查询一条动漫信息
    Anime selectById(@Param("a_id") Long id);

    //根据类型查询动漫信息
    List<Anime> selectByType(@Param("a_type") String type);

    //根据最高评分来查询动漫信息
    List<Anime>  selectByScore();

    //获取有多少页动漫
    Integer countById();
}
