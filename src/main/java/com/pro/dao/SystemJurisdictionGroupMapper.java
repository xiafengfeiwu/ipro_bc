package com.pro.dao;

import com.pro.entity.SystemJurisdictionGroup;
import com.pro.entity.SystemJurisdictionGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemJurisdictionGroupMapper {
    long countByExample(SystemJurisdictionGroupExample example);

    int deleteByExample(SystemJurisdictionGroupExample example);

    int deleteByPrimaryKey(String groupId);

    int insert(SystemJurisdictionGroup record);

    int insertSelective(SystemJurisdictionGroup record);

    List<SystemJurisdictionGroup> selectByExample(SystemJurisdictionGroupExample example);

    SystemJurisdictionGroup selectByPrimaryKey(String groupId);

    int updateByExampleSelective(@Param("record") SystemJurisdictionGroup record, @Param("example") SystemJurisdictionGroupExample example);

    int updateByExample(@Param("record") SystemJurisdictionGroup record, @Param("example") SystemJurisdictionGroupExample example);

    int updateByPrimaryKeySelective(SystemJurisdictionGroup record);

    int updateByPrimaryKey(SystemJurisdictionGroup record);
}