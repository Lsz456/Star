package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Anime;
import org.example.entity.Film;

import java.util.List;

public interface FilmService {
    List<Film> findAll(int beginNum);

    Film findById(Long id);

    List<Film> findByType(String type);
    List<Film> findByTypePage(String type, Integer page);

    List<Film> findByYear(String year);
    List<Film> findByYearPage(String year, Integer page);

    List<Film> findMaxScore();

    Integer countById();

    List<Film> findLike(String content);
}
