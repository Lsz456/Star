package org.example.controller;


import org.example.entity.Anime;
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

    //创建消息头
    private Boolean Code = false;

    //电影页面
    @RequestMapping("/check.com")
    public ModelAndView clickFilm(){

        Integer beginNum = 0;
        Integer previousPage = 0;
        Integer nextPage = beginNum + 1;

        //获取数据库的内容
        List<Film> filmList = filmService.findAll(beginNum);

        //获取数据页数
        Integer dataPage = filmService.countById();

        //把获取到的内容添加到mv里面
        mv.addObject("filmList",filmList);
        mv.addObject("beginNum",beginNum);
        mv.addObject("nextPage",nextPage);
        mv.addObject("previousPage",previousPage);
        mv.addObject("dataPage",dataPage);
        mv.addObject("Code",Code);

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
        mv.addObject("Code",Code);

        //判断是否是查询电影第一页
        if (beginNum == 1){
            beginNum -= 1;
        }else {
            //因为数据库的内容是从0开始的，除了第一页别的分页都应该-=1
            beginNum -= 1;
            //前端页面上的最大内容为14个
            beginNum *= 14;
        }
        List<Film> filmList = filmService.findAll(beginNum);

        mv.addObject("filmList",filmList);
        mv.setViewName("Film");

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

    //根据用户点击的类型进行筛选
    @RequestMapping("/filtrate.com")
    public ModelAndView clickFiltrate(String type, Integer page){
        //筛选后让其从第一页开始
        int beginNum = page;

        //通过类型筛选后获取内容总数
        List<Film> films;
        if (type.length() != 4){
            films = filmService.findByType(type);
        } else {
            films = filmService.findByYear(type);
        }

        //获取页数
        Integer totalQuantity = films.size();
        Integer number;
        if (totalQuantity % 14 != 0){
            number = totalQuantity / 14;
            number++;
        } else {
            number = totalQuantity / 14;
        }
        Integer dataPage = number;

        //获取上一页&下一页
        Integer previousPage = beginNum - 1;
        Integer nextPage = beginNum + 1;
        //更改信息头
        Code = true;

        mv.addObject("beginNum", beginNum);
        mv.addObject("dataPage", dataPage);
        mv.addObject("previousPage", previousPage);
        mv.addObject("nextPage", nextPage);
        mv.addObject("Code",Code);
        mv.addObject("type", type);


        //判断是否查询第一页数据
        if (beginNum == 1){
            //数据库内容是从0开始算的,页数都改-=1
            beginNum -= 1;
        }else {
            //数据库内容是从0开始算的，页数都改-=1
            beginNum -= 1;
            //前端每页最多展示14个内容
            beginNum *= 14;
        }

        //查询有几页数据
        List<Film> filmList;
        if (type.length() != 4){
            filmList = filmService.findByTypePage(type, beginNum);
        } else {
            filmList = filmService.findByYearPage(type, beginNum);
        }

        //把数据添加到mv
        mv.addObject("filmList",filmList);
        //跳转到Anime视图
        mv.setViewName("Film");

        return mv;
    }


    //点击播放按钮
    @RequestMapping(value = "/play.com")
    public ModelAndView clickPlay(Long name){
        //播放接口
//        String url = "https://jx.jsonplayer.com/player/?url=";
        String url = "https://jx.aidouer.net/?url=";

        //根据id获取内容
        Film film = filmService.findById(name);

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
