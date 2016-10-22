package com.pro.dao;

import com.pro.entity.TenantUserRoleRelExample;
import com.pro.entity.TenantUserRoleRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenantUserRoleRelMapper {
    long countByExample(TenantUserRoleRelExample example);

    int deleteByExample(TenantUserRoleRelExample example);

    int deleteByPrimaryKey(TenantUserRoleRelKey key);

    int insert(TenantUserRoleRelKey record);

    int insertSelective(TenantUserRoleRelKey record);

    List<TenantUserRoleRelKey> selectByExample(TenantUserRoleRelExample example);

    int updateByExampleSelective(@Param("record") TenantUserRoleRelKey record, @Param("example") TenantUserRoleRelExample example);

    int updateByExample(@Param("record") TenantUserRoleRelKey record, @Param("example") TenantUserRoleRelExample example);
}