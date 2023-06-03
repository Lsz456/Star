package org.example.service.imp;

import org.apache.ibatis.annotations.Param;
import org.example.dao.FilmDao;
import org.example.entity.Film;
import org.example.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Resource
    private FilmDao dao;

    @Override
    public List<Film> findAll(int beginNum) {
        return dao.selectAll(beginNum);
    }

    @Override
    public Film findById(Long id) {
        return dao.selectById(id);
    }

    @Override
    public List<Film> findByType(String type) {
        return dao.selectByType(type);
    }

    @Override
    public List<Film> findByTypePage(String type, Integer page) {
        return dao.selectByTypePage(type, page);
    }

    @Override
    public List<Film> findByYear(String year) {
        return dao.selectByYear(year);
    }

    @Override
    public List<Film> findByYearPage(String year, Integer page) {
        return dao.selectByYearPage(year, page);
    }

    @Override
    public List<Film> findMaxScore() {
        return dao.selectByScore();
    }

    @Override
    public Integer countById() {
        Integer number = null;
        int count = dao.countById();
        double num = 14;

        String str = String.valueOf(count / num);
        String[] arr = str.split("\\.");

        if(arr[1].length() > 3){
            number = Integer.valueOf(arr[0]);
            number++;
        }else if(arr[1].length() < 2){
            number = Integer.valueOf(arr[0]);
        }

        return number;
    }

    @Override
    public List<Film> findLike(String content) {
        return dao.selectLike(content);
    }
}
