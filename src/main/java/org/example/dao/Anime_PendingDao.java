package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Anime_Pending;

import java.util.List;

public interface Anime_PendingDao {
    List<Anime_Pending> selectByA_Id(@Param("a_id") Long id);

    Integer countByA_PId(@Param("a_id") Long id);

    Anime_Pending selectMovieUrls(@Param("a_id") Long id, @Param("a_p_numInt") Integer number);

    Integer MaxA_P_numInt(@Param("a_id") Long id);
}
