package com.sakura.mapper;

import com.sakura.pojo.Saquestion;
import com.sakura.pojo.SaquestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaquestionMapper {
    int countByExample(SaquestionExample example);

    int deleteByExample(SaquestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Saquestion record);

    int insertSelective(Saquestion record);

    List<Saquestion> selectByExample(SaquestionExample example);

    Saquestion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Saquestion record, @Param("example") SaquestionExample example);

    int updateByExample(@Param("record") Saquestion record, @Param("example") SaquestionExample example);

    int updateByPrimaryKeySelective(Saquestion record);

    int updateByPrimaryKey(Saquestion record);
}