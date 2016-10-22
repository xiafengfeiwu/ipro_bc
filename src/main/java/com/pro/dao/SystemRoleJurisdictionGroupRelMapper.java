package com.pro.dao;

import com.pro.entity.SystemRoleJurisdictionGroupRelExample;
import com.pro.entity.SystemRoleJurisdictionGroupRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemRoleJurisdictionGroupRelMapper {
    long countByExample(SystemRoleJurisdictionGroupRelExample example);

    int deleteByExample(SystemRoleJurisdictionGroupRelExample example);

    int deleteByPrimaryKey(SystemRoleJurisdictionGroupRelKey key);

    int insert(SystemRoleJurisdictionGroupRelKey record);

    int insertSelective(SystemRoleJurisdictionGroupRelKey record);

    List<SystemRoleJurisdictionGroupRelKey> selectByExample(SystemRoleJurisdictionGroupRelExample example);

    int updateByExampleSelective(@Param("record") SystemRoleJurisdictionGroupRelKey record, @Param("example") SystemRoleJurisdictionGroupRelExample example);

    int updateByExample(@Param("record") SystemRoleJurisdictionGroupRelKey record, @Param("example") SystemRoleJurisdictionGroupRelExample example);
}