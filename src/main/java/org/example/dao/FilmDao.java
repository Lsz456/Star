package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Film;

import java.util.List;

public interface FilmDao {
    //查询电影全部信息
    List<Film> selectAll(@Param("beginNum") int beginNum);

    //根据f_id查询一条电影信息
    Film selectById(@Param("f_id") Long id);

    //根据类型查询电影信息
    List<Film> selectByType(@Param("f_type") String type);
    List<Film> selectByTypePage(@Param("f_type") String type, @Param("page") Integer page);

    //根据年份查询电影信息
    List<Film> selectByYear(@Param("f_year") String year);
    List<Film> selectByYearPage(@Param("f_year") String year, @Param("page") Integer page);

    //根据最高评分来查询电影信息
    List<Film> selectByScore();

    //获取有多少页电影
    Integer countById();

    //根据内容模糊查询
    List<Film> selectLike(@Param("content") String content);
}
