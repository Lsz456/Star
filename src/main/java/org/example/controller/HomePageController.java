package org.example.controller;

import org.example.entity.Anime;
import org.example.entity.Film;
import org.example.entity.Tv;
import org.example.service.AnimeService;
import org.example.service.FilmService;
import org.example.service.TvService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/HomePage")
public class HomePageController {

    @Resource
    private FilmService filmService;

    @Resource
    private AnimeService animeService;

    @Resource
    private TvService tvService;

    //声明ModelAndView对象
    private ModelAndView mv = new ModelAndView();

    //主页效果
    @RequestMapping("/main.com")
    public ModelAndView HomePage(){
        //查询电影信息
        List<Film> films = filmService.findAll(0);
        //查询动漫信息
        List<Anime> animeList = animeService.findAll(0);
        //查询电视剧信息
        List<Tv> tvList = tvService.findAll(0);

        //把查询到的内容添加到mv里面
        mv.addObject("films",films);
        mv.addObject("animeList",animeList);
        mv.addObject("tvList",tvList);

        //跳转到HomePage.jsp视图
        mv.setViewName("HomePage");

        //返回mv到前端
        return mv;
    }

    //根据用户输入的内容模糊查询
    @RequestMapping("/find.com")
    public ModelAndView findFuzzyQuery(String content){
        //根据内容来进行模糊查询
        List<Anime> animeList = animeService.findLike(content);
        List<Film> filmList = filmService.findLike(content);
        List<Tv> tvList = tvService.findLike(content);

        Integer number = animeList.size() + filmList.size() + tvList.size();

        //把查询到的内容添加到mv里面
        mv.addObject("animeList",animeList);
        mv.addObject("filmList",filmList);
        mv.addObject("tvList",tvList);

        //跳转到FuzzyQuery.jsp视图
        mv.setViewName("FuzzyQuery");

        //返回mv到前端
        return mv;


    }

}
