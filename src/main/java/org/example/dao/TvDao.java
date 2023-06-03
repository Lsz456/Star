package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Anime;
import org.example.entity.Tv;

import java.util.List;

public interface TvDao {
    //查询电视剧信息并分页
    List<Tv> selectAll(@Param("beginNum") int beginNum);
    //根据t_id查询一条电视剧信息
    Tv selectById(@Param("t_id") Long id);

    //根据类型查询电视剧信息
    List<Tv> selectByType(@Param("t_type") String type);
    List<Tv> selectByTypePage(@Param("t_type") String type, @Param("page") Integer page);

    //根据年份查询电视剧信息
    List<Tv> selectByYear(@Param("year") String year);
    List<Tv> selectByYearPage(@Param("year") String year, @Param("page") Integer page);

    //根据最高评分来查询电视剧信息
    List<Tv>  selectByScore();

    //获取有多少页数据
    Integer countById();

    //根据内容模糊查询
    List<Tv> selectLike(@Param("content") String content);
}
