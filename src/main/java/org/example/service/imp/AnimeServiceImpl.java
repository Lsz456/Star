package org.example.service.imp;

import org.example.dao.AnimeDao;
import org.example.dao.Anime_PendingDao;
import org.example.entity.Anime;
import org.example.entity.Anime_Pending;
import org.example.service.AnimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService {

    @Resource
    private AnimeDao dao;

    @Resource
    private Anime_PendingDao dao_pendingDao;

    @Override
    public List<Anime> findAll(int beginNum) {
        return dao.selectAll(beginNum);
    }

    @Override
    public Anime findById(Long id) {
        return dao.selectById(id);
    }

    @Override
    public List<Anime_Pending> findByA_Id(Long id) {
        return dao_pendingDao.selectByA_Id(id);
    }

    @Override
    public Anime_Pending findMovieUrls(Long id, Integer number) {
        return dao_pendingDao.selectMovieUrls(id, number);
    }

    @Override
    public Integer MaxA_P_numInt(Long id) {
        return dao_pendingDao.MaxA_P_numInt(id);
    }

    @Override
    public Long countByA_PId(Long id) {
        Long number;
        int count = dao_pendingDao.countByA_PId(id);
        double num = 13;
        String str = String.valueOf(count / num);
        String[] array = str.split("\\.");
        Long a = Long.valueOf(array[0]);
        if (array[1].length() > 3){
            a = a + 1;
        }
        number = a * 46;
        number += 30;

        return number;
    }

    @Override
    public List<Anime> findByType(String type) {
        return dao.selectByType(type);
    }

    @Override
    public List<Anime> findByScore() {
        return dao.selectByScore();
    }

    @Override
    public Integer countById() {
        Integer number;
        int count = dao.countById();
        double num = 14;

        String str = String.valueOf(count / num);
        String[] array = str.split("\\.");

        if (array[1].length() > 3){
            number = Integer.valueOf(array[0]);
            number++;
        }else {
            number = Integer.valueOf(array[0]);
        }

        return number;
    }
}
