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

    private ModelAndView mv = new ModelAndView();

    //主页效果
    @RequestMapping("/main.com")
    public ModelAndView HomePage(){

        List<Film> films = filmService.findAll(0);
        List<Anime> animeList = animeService.findAll(0);
        List<Tv> tvList = tvService.findAll(0);

        mv.addObject("films",films);
        mv.addObject("animeList",animeList);
        mv.addObject("tvList",tvList);

        mv.setViewName("HomePage");
        return mv;
    }
}
