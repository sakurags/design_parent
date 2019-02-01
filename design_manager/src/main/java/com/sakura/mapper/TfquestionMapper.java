package com.sakura.mapper;

import com.sakura.pojo.Tfquestion;
import com.sakura.pojo.TfquestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TfquestionMapper {
    int countByExample(TfquestionExample example);

    int deleteByExample(TfquestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tfquestion record);

    int insertSelective(Tfquestion record);

    List<Tfquestion> selectByExample(TfquestionExample example);

    Tfquestion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tfquestion record, @Param("example") TfquestionExample example);

    int updateByExample(@Param("record") Tfquestion record, @Param("example") TfquestionExample example);

    int updateByPrimaryKeySelective(Tfquestion record);

    int updateByPrimaryKey(Tfquestion record);
}