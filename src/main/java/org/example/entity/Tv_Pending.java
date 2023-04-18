package org.example.entity;

public class Tv_Pending {
    //表id(主键)
    private Integer t_p_id;
    //电视剧名称
    private String t_p_title;
    //第几集
    private Integer t_p_numInt;
    //播放路径
    private String t_p_movieUrls;
    //Tv表中的主键(外键索引)
    private String t_id;

    public Integer getT_p_id() {
        return t_p_id;
    }

    public void setT_p_id(Integer t_p_id) {
        this.t_p_id = t_p_id;
    }

    public String getT_p_title() {
        return t_p_title;
    }

    public void setT_p_title(String t_p_title) {
        this.t_p_title = t_p_title;
    }

    public Integer getT_p_numInt() {
        return t_p_numInt;
    }

    public void setT_p_numInt(Integer t_p_numInt) {
        this.t_p_numInt = t_p_numInt;
    }

    public String getT_p_movieUrls() {
        return t_p_movieUrls;
    }

    public void setT_p_movieUrls(String t_p_movieUrls) {
        this.t_p_movieUrls = t_p_movieUrls;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }
}
