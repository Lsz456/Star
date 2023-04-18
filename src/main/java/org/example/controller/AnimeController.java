package org.example.controller;

import org.example.entity.Anime;
import org.example.entity.Anime_Pending;
import org.example.service.AnimeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/cartoon")
public class AnimeController {

    @Resource
    private AnimeService animeService;

    private ModelAndView mv = new ModelAndView();

    //点击动漫效果
    @RequestMapping("/check.com")
    public ModelAndView clickAnime(){

        //判断页数为1时从0开始
        Integer beginNum = 0;
        Integer previousPage = 0;
        Integer nextPage = beginNum + 1;

        //获取数据库的内容
        List<Anime> animeList = animeService.findAll(beginNum);
        Integer dataPage = animeService.countById();

        //把获取到的内容添加到mv里面
        mv.addObject("animeList",animeList);
        mv.addObject("beginNum",beginNum);
        mv.addObject("dataPage",dataPage);
        mv.addObject("previousPage",previousPage);
        mv.addObject("nextPage",nextPage);

        //指定跳转视图
        mv.setViewName("Anime");

        return mv;
    }

    //上一页&下一页
    @RequestMapping("/nextPage.com")
    public ModelAndView nextPage(Integer beginNum){

        //获取页数
        Integer dataPage = animeService.countById();

        //获取上一页&下一页
        Integer previousPage = beginNum - 1;
        Integer nextPage = beginNum + 1;

        mv.addObject("beginNum",beginNum);
        mv.addObject("dataPage",dataPage);
        mv.addObject("previousPage",previousPage);
        mv.addObject("nextPage",nextPage);

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
        //获取数据库的内容
        List<Anime> animeList = animeService.findAll(beginNum);;

        //把数据添加到mv
        mv.addObject("animeList",animeList);
        //跳转到Anime视图
        mv.setViewName("Anime");

        return mv;
    }

    //点击视频进行跳转
    @RequestMapping("/video.com")
    public ModelAndView clickVideo(Long name){

        String videoUrl = "cartoon/check.com";
        String url = "cartoon/video.com?name=";

        Anime anime = animeService.findById(name);
        List<Anime> animeList = animeService.findAll(0);
        List<Anime_Pending> anime_pendingList = animeService.findByA_Id(name);
        //HD播放的高度
        Long number = animeService.countByA_PId(name);

        mv.addObject("number",number);
        mv.addObject("anime", anime);
        mv.addObject("animeList", animeList);
        mv.addObject("anime_pendingList", anime_pendingList);
        mv.addObject("videoUrl", videoUrl);
        mv.addObject("url", url);
        mv.setViewName("PlayVideoAnime");

        return mv;
    }

    //点击播放按钮
    @RequestMapping("/play.com")
    public ModelAndView clickPlay(Long play_Id, Integer numInt){
        String url = "https://jx.jsonplayer.com/player/?url=";

        //获取anime_p里面的播放链接
        Anime_Pending ap = animeService.findMovieUrls(play_Id, numInt);
        //获取anime表的具体内容
        Anime anime = animeService.findById(play_Id);
        //获取play_Id最大集数
        Integer maxNumber = animeService.MaxA_P_numInt(play_Id);


        mv.addObject("url",url);
        mv.addObject("ap",ap);
        mv.addObject("anime",anime);
        mv.addObject("maxNumber",maxNumber);

        mv.setViewName("PlayAnime");

        return mv;
    }

    //切换线路
    @RequestMapping("/switchRoutes.com")
    public ModelAndView changeLine(Long num_Id,Long play_Id){

        return mv;
    }
}
