package com.pro.dao;

import com.pro.entity.SystemJurisdiction;
import com.pro.entity.SystemJurisdictionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemJurisdictionMapper {
    long countByExample(SystemJurisdictionExample example);

    int deleteByExample(SystemJurisdictionExample example);

    int deleteByPrimaryKey(String jurisdictionId);

    int insert(SystemJurisdiction record);

    int insertSelective(SystemJurisdiction record);

    List<SystemJurisdiction> selectByExample(SystemJurisdictionExample example);

    SystemJurisdiction selectByPrimaryKey(String jurisdictionId);

    int updateByExampleSelective(@Param("record") SystemJurisdiction record, @Param("example") SystemJurisdictionExample example);

    int updateByExample(@Param("record") SystemJurisdiction record, @Param("example") SystemJurisdictionExample example);

    int updateByPrimaryKeySelective(SystemJurisdiction record);

    int updateByPrimaryKey(SystemJurisdiction record);
}