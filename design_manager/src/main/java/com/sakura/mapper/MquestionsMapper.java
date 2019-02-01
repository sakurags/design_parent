package com.sakura.mapper;

import com.sakura.pojo.Mquestions;
import com.sakura.pojo.MquestionsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MquestionsMapper {
    int countByExample(MquestionsExample example);

    int deleteByExample(MquestionsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Mquestions record);

    int insertSelective(Mquestions record);

    List<Mquestions> selectByExample(MquestionsExample example);

    Mquestions selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Mquestions record, @Param("example") MquestionsExample example);

    int updateByExample(@Param("record") Mquestions record, @Param("example") MquestionsExample example);

    int updateByPrimaryKeySelective(Mquestions record);

    int updateByPrimaryKey(Mquestions record);
}