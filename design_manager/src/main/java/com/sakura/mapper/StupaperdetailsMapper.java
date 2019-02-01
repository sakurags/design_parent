package com.sakura.mapper;

import com.sakura.pojo.Stupaperdetails;
import com.sakura.pojo.StupaperdetailsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StupaperdetailsMapper {
    int countByExample(StupaperdetailsExample example);

    int deleteByExample(StupaperdetailsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Stupaperdetails record);

    int insertSelective(Stupaperdetails record);

    List<Stupaperdetails> selectByExample(StupaperdetailsExample example);

    Stupaperdetails selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Stupaperdetails record, @Param("example") StupaperdetailsExample example);

    int updateByExample(@Param("record") Stupaperdetails record, @Param("example") StupaperdetailsExample example);

    int updateByPrimaryKeySelective(Stupaperdetails record);

    int updateByPrimaryKey(Stupaperdetails record);
}