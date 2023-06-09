package org.example.controller;

import org.example.entity.Anime;
import org.example.entity.Tv;
import org.example.entity.Tv_Pending;
import org.example.service.TvService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/teleplay")
public class TvController {

    @Resource
    private TvService tvService;

    private ModelAndView mv = new ModelAndView();

    private Boolean Code = false;

    //点击电视剧效果
    @RequestMapping("/check.com")
    public ModelAndView clickTv(){

        Integer beginNum = 0;
        Integer previousPage = 0;
        Integer nextPage = beginNum + 1;


        //获取数据库的内容
        List<Tv> tvList = tvService.findAll(beginNum);
        Integer dataPage = tvService.countById();

        //把获取到的内容添加到mv里面
        mv.addObject("tvList",tvList);
        mv.addObject("beginNum",beginNum);
        mv.addObject("dataPage",dataPage);
        mv.addObject("previousPage",previousPage);
        mv.addObject("nextPage",nextPage);
        mv.addObject("Code",Code);

        //指定跳转视图
        mv.setViewName("TV");

        return mv;
    }

    //上一页&下一页
    @RequestMapping("/nextPage.com")
    public ModelAndView nextPage(Integer beginNum){
        //获取页数
        Integer dataPage = tvService.countById();
        //上一页&下一页
        Integer previousPage = beginNum - 1;
        Integer nextPage = beginNum + 1;

        //把获取到的内容添加到mv里面
        mv.addObject("beginNum",beginNum);
        mv.addObject("dataPage",dataPage);
        mv.addObject("previousPage",previousPage);
        mv.addObject("nextPage",nextPage);
        mv.addObject("Code",Code);

        //判断是否查询的是第一页数据
        if (beginNum == 1) {
            //数据库是从0开始查询的，第一页是从0开始的
            beginNum -= 1;
        } else {
            //因为数据库的内容是从0开始的，除了第一页别的分页都应该-=1
            beginNum--;
            //前端页面最多展示14个内容
            beginNum *= 14;
        }

        //获取数据的内容
        List<Tv> tvList = tvService.findAll(beginNum);

        //把数据添加到mv
        mv.addObject("tvList",tvList);
        //跳转到Tv视图
        mv.setViewName("TV");

        return mv;
    }

    //根据用户点击的类型进行筛选
    @RequestMapping("/filtrate.com")
    public ModelAndView clickFiltrate(String type, Integer page){
        //筛选后让其从第一页开始
        int beginNum = page;

        //通过类型筛选后获取内容总数
        List<Tv> tvs;
        if (type.length() != 4){
            tvs = tvService.findByType(type);
        } else {
            tvs = tvService.findByYear(type);
        }

        //获取页数
        Integer totalQuantity = tvs.size();
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
        List<Tv> tvList;
        if (type.length() != 4){
            tvList = tvService.findByTypePage(type, beginNum);
        } else {
            tvList = tvService.findByYearPage(type, beginNum);
        }

        //把数据添加到mv
        mv.addObject("tvList",tvList);
        //跳转到Anime视图
        mv.setViewName("TV");

        return mv;
    }

    //点击视频进行跳转
    @RequestMapping("/video.com")
    public ModelAndView clickVideo(Long name){

        String videoUrl = "teleplay/check.com";
        String url = "teleplay/video.com?name=";

        //根据name值查询tv表中的内容
        Tv tv = tvService.findById(name);
        //获取tv表第一页里面的数据
        List<Tv> tvList = tvService.findAll(0);
        //根据name值获取有多少集的内容
        List<Tv_Pending> tv_pendingList = tvService.findByT_Id(name);
        //HD播放的高度
        Long number = tvService.countByT_P_Id(name);

        mv.addObject("number", number);
        mv.addObject("tv_pendingList", tv_pendingList);
        mv.addObject("tv", tv);
        mv.addObject("tvList", tvList);
        mv.addObject("videoUrl", videoUrl);
        mv.addObject("url", url);
        mv.setViewName("PlayVideoTv");

        return mv;
    }

    //点击播放按钮
    @RequestMapping("/play.com")
    public ModelAndView clickPlay(Long play_Id, Integer numInt){
//        String url = "https://jx.jsonplayer.com/player/?url=";
        String url = "https://jx.aidouer.net/?url=";

        //获取tv_p里面的播放链接
        Tv_Pending tp = tvService.findMovieUrls(play_Id, numInt);
        //根据play_Id获取tv表里面的内容
        Tv tv = tvService.findById(play_Id);
        //获取play_Id最大集数
        Integer maxNumber = tvService.MaxNumber(play_Id);

        mv.addObject("tp",tp);
        mv.addObject("tv",tv);
        mv.addObject("url",url);
        mv.addObject("maxNumber",maxNumber);

        mv.setViewName("PlayTv");

        return mv;
    }
}
