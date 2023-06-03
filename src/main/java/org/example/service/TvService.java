package org.example.service;

import org.example.entity.Anime;
import org.example.entity.Anime_Pending;
import org.example.entity.Tv;
import org.example.entity.Tv_Pending;

import java.util.List;

public interface TvService {
    List<Tv> findAll(int beginNum);

    Tv findById(Long id);

    List<Tv_Pending> findByT_Id(Long id);

    Tv_Pending findMovieUrls(Long id, Integer number);

    Integer MaxNumber(Long id);

    Long countByT_P_Id(Long id);

    List<Tv> findByType(String type);
    List<Tv> findByTypePage(String type, Integer page);

    List<Tv> findByYear(String year);
    List<Tv> findByYearPage(String year, Integer page);

    List<Tv>  findByScore();

    Integer countById();

    List<Tv> findLike(String content);
}
