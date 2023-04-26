package org.example.controller;


import org.example.entity.Film;
import org.example.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/film")
public class FilmController {

    //声明FilmService对象，并同过@Resource自动转配对象
    @Resource
    private FilmService filmService;

    //声明ModelAndView对象
    private ModelAndView mv = new ModelAndView();

    //电影页面
    @RequestMapping("/check.com")
    public ModelAndView clickFilm(){

        Integer beginNum = 0;
        Integer previousPage = 0;
        Integer nextPage = beginNum + 1;

        //获取数据库的内容
        List<Film> films = filmService.findAll(beginNum);

        //获取数据页数
        Integer dataPage = filmService.countById();

        //把获取到的内容添加到mv里面
        mv.addObject("films",films);
        mv.addObject("beginNum",beginNum);
        mv.addObject("nextPage",nextPage);
        mv.addObject("previousPage",previousPage);
        mv.addObject("dataPage",dataPage);

        //跳转至Film.jsp视图
        mv.setViewName("Film");

        return mv;
    }

    //下一页
    @RequestMapping("/nextPage.com")
    public ModelAndView nextPage(Integer beginNum){

        //获取数据页数
        Integer dataPage = filmService.countById();

        Integer previousPage = beginNum - 1;
        Integer nextPage = beginNum + 1;

        mv.addObject("beginNum",beginNum);
        mv.addObject("dataPage",dataPage);
        mv.addObject("previousPage",previousPage);
        mv.addObject("nextPage",nextPage);

        List<Film> films = null;

        //判断是否是查询电影第一页
        if (beginNum == 1){
            beginNum -= 1;
            //获取数据库的内容
            films = filmService.findAll(beginNum);
            //把获取到的内容添加到mv里面
            mv.addObject("films",films);
            //指定跳转视图
            mv.setViewName("Film");
        }else {
            //因为数据库的内容是从0开始的，除了第一页别的分页都应该-=1
            beginNum -= 1;
            //前端页面上的最大内容为14个
            beginNum *= 14;
            films = filmService.findAll(beginNum);
            mv.addObject("films",films);
            mv.setViewName("Film");
        }
        return mv;
    }

    //点击进行跳转
    @RequestMapping(value = "/video.com")
    public ModelAndView clickVideo(Long name){

        String video = "电影";
        String videoUrl = "film/check.com";
        String url = "film/video.com?name=";

        Film film = filmService.findById(name);
        List<Film> films = filmService.findAll(0);

        mv.addObject("film", film);
        mv.addObject("films", films);
        mv.addObject("video",video);
        mv.addObject("videoUrl",videoUrl);
        mv.addObject("url",url);

        //即将跳转的视图
        mv.setViewName("PlayVideoFilm");

        return mv;
    }

    //点击播放按钮
    @RequestMapping(value = "/play.com")
    public ModelAndView clickPlay(Long name){

        //根据id获取内容
        Film film = filmService.findById(name);
        String url = "https://jx.jsonplayer.com/player/?url=";

        mv.addObject("url",url);
        mv.addObject("film",film);

        mv.setViewName("PlayFilm");

        return mv;
    }

    //切换线路
    @RequestMapping("/switchRoutes.com")
    public ModelAndView switchingLine(Long name){

        Film film = filmService.findById(name);
        String url = "https://yparse.7te.cc/index.php?url=";
        String video = "电影";

        mv.addObject("url",url);
        mv.addObject("video",video);
        mv.addObject("film",film);

        mv.setViewName("PlayFilm");

        return mv;
    }
}
