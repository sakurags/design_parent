package com.sakura.mapper;

import com.sakura.pojo.Papers;
import com.sakura.pojo.PapersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PapersMapper {
    int countByExample(PapersExample example);

    int deleteByExample(PapersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Papers record);

    int insertSelective(Papers record);

    List<Papers> selectByExample(PapersExample example);

    Papers selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Papers record, @Param("example") PapersExample example);

    int updateByExample(@Param("record") Papers record, @Param("example") PapersExample example);

    int updateByPrimaryKeySelective(Papers record);

    int updateByPrimaryKey(Papers record);
}