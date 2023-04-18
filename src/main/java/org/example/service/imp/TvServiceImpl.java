package org.example.service.imp;

import org.example.dao.TvDao;
import org.example.dao.Tv_PendingDao;
import org.example.entity.Tv;
import org.example.entity.Tv_Pending;
import org.example.service.TvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TvServiceImpl implements TvService {

    @Resource
    private TvDao dao;

    @Resource
    private Tv_PendingDao dao_pending;

    @Override
    public List<Tv> findAll(int beginNum) {
        return dao.selectAll(beginNum);
    }

    @Override
    public Tv findById(Long id) {
        return dao.selectById(id);
    }

    @Override
    public List<Tv_Pending> findByT_Id(Long id) {
        return dao_pending.selectByT_Id(id);
    }

    @Override
    public Tv_Pending findMovieUrls(Long id, Integer number) {
        return dao_pending.selectMovieUrls(id, number);
    }

    @Override
    public Integer MaxNumber(Long id) {
        return dao_pending.MaxNumber(id);
    }

    @Override
    public Long countByT_P_Id(Long id) {
        Long number;
        int count = dao_pending.countByT_P_Id(id);
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
    public List<Tv> findByType(String type) {
        return dao.selectByType(type);
    }

    @Override
    public List<Tv> findByScore() {
        return dao.selectByScore();
    }

    @Override
    public Integer countById() {
        Integer number = null;
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
