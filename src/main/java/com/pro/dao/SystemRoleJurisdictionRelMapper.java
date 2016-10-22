package com.pro.dao;

import com.pro.entity.SystemRoleJurisdictionRelExample;
import com.pro.entity.SystemRoleJurisdictionRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemRoleJurisdictionRelMapper {
    long countByExample(SystemRoleJurisdictionRelExample example);

    int deleteByExample(SystemRoleJurisdictionRelExample example);

    int deleteByPrimaryKey(SystemRoleJurisdictionRelKey key);

    int insert(SystemRoleJurisdictionRelKey record);

    int insertSelective(SystemRoleJurisdictionRelKey record);

    List<SystemRoleJurisdictionRelKey> selectByExample(SystemRoleJurisdictionRelExample example);

    int updateByExampleSelective(@Param("record") SystemRoleJurisdictionRelKey record, @Param("example") SystemRoleJurisdictionRelExample example);

    int updateByExample(@Param("record") SystemRoleJurisdictionRelKey record, @Param("example") SystemRoleJurisdictionRelExample example);
}