package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Film;

import java.util.List;

public interface FilmService {
    List<Film> findAll(int beginNum);

    Film findById(Long id);

    List<Film> findByType(String type);

    List<Film> findMaxScore();

    Integer countById();
}
