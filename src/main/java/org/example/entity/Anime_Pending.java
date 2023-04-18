package org.example.entity;

public class Anime_Pending {
    //表id(主键)
    private Integer a_p_id;
    //动漫名称
    private String a_p_title;
    //第几集
    private Integer a_p_numInt;
    //播放路径
    private String a_p_movieUrls;
    //Anime表中的主键(外键索引)
    private Long a_id;

    public Integer getA_p_id() {
        return a_p_id;
    }

    public void setA_p_id(Integer a_p_id) {
        this.a_p_id = a_p_id;
    }

    public String getA_p_title() {
        return a_p_title;
    }

    public void setA_p_title(String a_p_title) {
        this.a_p_title = a_p_title;
    }

    public Integer getA_p_numInt() {
        return a_p_numInt;
    }

    public void setA_p_numInt(Integer a_p_numInt) {
        this.a_p_numInt = a_p_numInt;
    }

    public String getA_p_movieUrls() {
        return a_p_movieUrls;
    }

    public void setA_p_movieUrls(String a_p_movieUrls) {
        this.a_p_movieUrls = a_p_movieUrls;
    }

    public Long getA_id() {
        return a_id;
    }

    public void setA_id(Long a_id) {
        this.a_id = a_id;
    }
}
