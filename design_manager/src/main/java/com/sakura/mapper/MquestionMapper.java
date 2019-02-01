package com.sakura.mapper;

import com.sakura.pojo.Mquestion;
import com.sakura.pojo.MquestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MquestionMapper {
    int countByExample(MquestionExample example);

    int deleteByExample(MquestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Mquestion record);

    int insertSelective(Mquestion record);

    List<Mquestion> selectByExample(MquestionExample example);

    Mquestion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Mquestion record, @Param("example") MquestionExample example);

    int updateByExample(@Param("record") Mquestion record, @Param("example") MquestionExample example);

    int updateByPrimaryKeySelective(Mquestion record);

    int updateByPrimaryKey(Mquestion record);
}