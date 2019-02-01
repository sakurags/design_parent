package com.sakura.mapper;

import com.sakura.pojo.Scmid;
import com.sakura.pojo.ScmidExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScmidMapper {
    int countByExample(ScmidExample example);

    int deleteByExample(ScmidExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Scmid record);

    int insertSelective(Scmid record);

    List<Scmid> selectByExample(ScmidExample example);

    Scmid selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Scmid record, @Param("example") ScmidExample example);

    int updateByExample(@Param("record") Scmid record, @Param("example") ScmidExample example);

    int updateByPrimaryKeySelective(Scmid record);

    int updateByPrimaryKey(Scmid record);
}