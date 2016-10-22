package com.pro.dao;

import com.pro.entity.SystemJurisdictionMenuRelExample;
import com.pro.entity.SystemJurisdictionMenuRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemJurisdictionMenuRelMapper {
    long countByExample(SystemJurisdictionMenuRelExample example);

    int deleteByExample(SystemJurisdictionMenuRelExample example);

    int deleteByPrimaryKey(SystemJurisdictionMenuRelKey key);

    int insert(SystemJurisdictionMenuRelKey record);

    int insertSelective(SystemJurisdictionMenuRelKey record);

    List<SystemJurisdictionMenuRelKey> selectByExample(SystemJurisdictionMenuRelExample example);

    int updateByExampleSelective(@Param("record") SystemJurisdictionMenuRelKey record, @Param("example") SystemJurisdictionMenuRelExample example);

    int updateByExample(@Param("record") SystemJurisdictionMenuRelKey record, @Param("example") SystemJurisdictionMenuRelExample example);
}