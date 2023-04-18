package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Tv_Pending;

import java.util.List;

public interface Tv_PendingDao {
    //根据t_id获取有多少集电视剧和播放路径
    List<Tv_Pending> selectByT_Id(@Param("t_id") Long id);
    //根据t_id查询有多少集
    Integer countByT_P_Id(@Param("t_id") Long id);
    //根据t_p_id查询播放路径
    Tv_Pending selectMovieUrls(@Param("t_id") Long id, @Param("t_p_numInt") Integer number);
    //根据t_id获取它的最大集数
    Integer MaxNumber(@Param("t_id") Long id);
}
