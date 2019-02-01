package com.sakura.mapper;

import com.sakura.pojo.Ctmid;
import com.sakura.pojo.CtmidExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CtmidMapper {
    int countByExample(CtmidExample example);

    int deleteByExample(CtmidExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Ctmid record);

    int insertSelective(Ctmid record);

    List<Ctmid> selectByExample(CtmidExample example);

    Ctmid selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Ctmid record, @Param("example") CtmidExample example);

    int updateByExample(@Param("record") Ctmid record, @Param("example") CtmidExample example);

    int updateByPrimaryKeySelective(Ctmid record);

    int updateByPrimaryKey(Ctmid record);
}