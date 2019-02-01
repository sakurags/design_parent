package com.sakura.mapper;

import com.sakura.pojo.Fquestion;
import com.sakura.pojo.FquestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FquestionMapper {
    int countByExample(FquestionExample example);

    int deleteByExample(FquestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Fquestion record);

    int insertSelective(Fquestion record);

    List<Fquestion> selectByExample(FquestionExample example);

    Fquestion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Fquestion record, @Param("example") FquestionExample example);

    int updateByExample(@Param("record") Fquestion record, @Param("example") FquestionExample example);

    int updateByPrimaryKeySelective(Fquestion record);

    int updateByPrimaryKey(Fquestion record);
}