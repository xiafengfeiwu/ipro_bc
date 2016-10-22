package com.pro.dao;

import com.pro.entity.SystemJurisdictionGroupRelExample;
import com.pro.entity.SystemJurisdictionGroupRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemJurisdictionGroupRelMapper {
    long countByExample(SystemJurisdictionGroupRelExample example);

    int deleteByExample(SystemJurisdictionGroupRelExample example);

    int deleteByPrimaryKey(SystemJurisdictionGroupRelKey key);

    int insert(SystemJurisdictionGroupRelKey record);

    int insertSelective(SystemJurisdictionGroupRelKey record);

    List<SystemJurisdictionGroupRelKey> selectByExample(SystemJurisdictionGroupRelExample example);

    int updateByExampleSelective(@Param("record") SystemJurisdictionGroupRelKey record, @Param("example") SystemJurisdictionGroupRelExample example);

    int updateByExample(@Param("record") SystemJurisdictionGroupRelKey record, @Param("example") SystemJurisdictionGroupRelExample example);
}