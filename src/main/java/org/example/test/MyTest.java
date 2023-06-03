package org.example.test;

import org.example.entity.Anime;
import org.example.entity.Film;
import org.example.entity.Tv;
import org.example.service.AnimeService;
import org.example.service.FilmService;
import org.example.service.TvService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class MyTest {
    @Test
    public void testFilm() {
        String config = "conf/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        FilmService service = (FilmService) context.getBean("filmServiceImpl");
        String name = "喜剧";
//        List<Film> lists = service.findById(202030000021L);
//        lists.forEach(l-> System.out.println(l));
        Film lists = service.findById(202030000021L);
        System.out.print(lists);
    }
    @Test
    public void testAnime(){
        String config = "conf/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        AnimeService service = (AnimeService) ctx.getBean("animeServiceImpl");
//        List<Anime> lists = service.findByType("冒险");
//        lists.forEach(l-> System.out.println(l));
        Long A = 5759249974404201L;
        Anime anime = service.findById(A);
        System.out.println(anime);
    }
    @Test
    public void testTv(){
//        String config = "conf/applicationContext.xml";
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
//        TvService service = (TvService) ctx.getBean("tvServiceImpl");
//
//        List<Tv> list = service.findAll(0);
//        list.forEach(l-> System.out.println(l));
        int num = 5;
        for (int i = 0; i < 5; i++) {
            System.out.println(num-=2);
        }
    }


    @Test
    public void test02() {
//        int a = 3;
//        a -= 1;
//        System.out.println(a);
//        a *= 14;
//        System.out.println(a);
//        int a = 120;
//        double n = 14;
//        String str = String.valueOf(a / n);
//        String[] arr = str.split("\\.");
//        int c = Integer.valueOf(arr[0]);
//        c++;
//        System.out.println(c);
        int b = 1;
        Integer[] a = new Integer[7];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
//        for (int i = 5; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
        if (b % 2 != 0){
            for (int j = (b - 1) * 5; j < a.length; j++) {
                if(j != 0){
                    if (j % 5  == 0) {
                        if((b - 1) * 5 % j != 0 || j == 5){
                            break;
                        }
                    }
                }
                System.out.println(a[j]);
            }
        }else {
            for (int j = (b - 1) * 5; j < a.length; j++){
                System.out.println(a[j]);
                if (j % 10 == 0) {
                    break;
                }
            }
        }
    }

    @Test
    public void testMultiList(){
//        String config = "/conf/applicationContext.xml";
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
//        AnimeService service = (AnimeService) ctx.getBean("animeServiceImpl");
//        Anime anime = service.findLike("苍兰诀");
//        service.findByYear("2023");

//        FilmService service = (FilmService) ctx.getBean("filmServiceImpl");
//        service.findLike("苍兰诀");


//        TvService service = (TvService) ctx.getBean("tvServiceImpl");
//        service.findLike("苍兰诀");
//        int a = 100;
//        a++;
//        System.out.println(a);
    }
}
