package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Anime;
import org.example.entity.Anime_Pending;

import java.util.List;

public interface AnimeService {
    List<Anime> findAll(int beginNum);

    Anime findById(Long id);

    List<Anime_Pending> findByA_Id(Long id);

    Anime_Pending findMovieUrls(Long id, Integer number);

    Integer MaxA_P_numInt(Long id);

    Long countByA_PId(Long id);

    List<Anime> findByType(String type);
    List<Anime> findByTypePage(String type, Integer page);

    List<Anime> findByYear(String year);
    List<Anime> findByYearPage(String year, Integer page);

    List<Anime>  findByScore();

    Integer countById();

    List<Anime> findLike(String content);
}
