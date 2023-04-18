package org.example.entity;

public class Anime {
    //动漫id
    private Long a_id;
    //动漫名称
    private String a_title;
    //动漫评分
    private String a_score;
    //动漫总集数
    private String a_total_number;
    //动漫类型
    private String a_type;
    //最后更新时间
    private String a_update_time;
    //动漫图片地址
    private String a_image_url;
    //简介
    private String a_description;

    public Long getA_id() {
        return a_id;
    }

    public void setA_id(Long a_id) {
        this.a_id = a_id;
    }

    public String getA_title() {
        return a_title;
    }

    public void setA_title(String a_title) {
        this.a_title = a_title;
    }

    public String getA_score() {
        return a_score;
    }

    public void setA_score(String a_score) {
        this.a_score = a_score;
    }

    public String getA_total_number() {
        return a_total_number;
    }

    public void setA_total_number(String a_total_number) {
        this.a_total_number = a_total_number;
    }

    public String getA_type() {
        return a_type;
    }

    public void setA_type(String a_type) {
        this.a_type = a_type;
    }

    public String getA_update_time() {
        return a_update_time;
    }

    public void setA_update_time(String a_update_time) {
        this.a_update_time = a_update_time;
    }

    public String getA_image_url() {
        return a_image_url;
    }

    public void setA_image_url(String a_image_url) {
        this.a_image_url = a_image_url;
    }

    public String getA_description() {
        return a_description;
    }

    public void setA_description(String a_description) {
        this.a_description = a_description;
    }
}
