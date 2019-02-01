package com.sakura.mapper;

import com.sakura.pojo.Paperdetails;
import com.sakura.pojo.PaperdetailsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperdetailsMapper {
    int countByExample(PaperdetailsExample example);

    int deleteByExample(PaperdetailsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Paperdetails record);

    int insertSelective(Paperdetails record);

    List<Paperdetails> selectByExample(PaperdetailsExample example);

    Paperdetails selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Paperdetails record, @Param("example") PaperdetailsExample example);

    int updateByExample(@Param("record") Paperdetails record, @Param("example") PaperdetailsExample example);

    int updateByPrimaryKeySelective(Paperdetails record);

    int updateByPrimaryKey(Paperdetails record);
}