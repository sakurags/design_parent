package com.sakura.mapper;

import com.sakura.pojo.Aquestion;
import com.sakura.pojo.AquestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AquestionMapper {
    int countByExample(AquestionExample example);

    int deleteByExample(AquestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Aquestion record);

    int insertSelective(Aquestion record);

    List<Aquestion> selectByExample(AquestionExample example);

    Aquestion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Aquestion record, @Param("example") AquestionExample example);

    int updateByExample(@Param("record") Aquestion record, @Param("example") AquestionExample example);

    int updateByPrimaryKeySelective(Aquestion record);

    int updateByPrimaryKey(Aquestion record);
}