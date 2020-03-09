package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.TeaInfoTrack;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface InfoTrackMapper extends Mapper<TeaInfoTrack>, DeleteByIdListMapper<TeaInfoTrack,Long> {
    @Select("<script>"+
            "select * from tea_info_track t where 1=1"+
            "<if test='userId!=null'>"+
            "and t.user_id=#{userId}"+
            "</if>"+
            "</script>")
    List<TeaInfoTrack> selectall(@Param("userId") Long userId);
}
