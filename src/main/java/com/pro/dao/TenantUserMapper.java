package com.pro.dao;

import com.pro.entity.TenantUser;
import com.pro.entity.TenantUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenantUserMapper {
    long countByExample(TenantUserExample example);

    int deleteByExample(TenantUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(TenantUser record);

    int insertSelective(TenantUser record);

    List<TenantUser> selectByExample(TenantUserExample example);

    TenantUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") TenantUser record, @Param("example") TenantUserExample example);

    int updateByExample(@Param("record") TenantUser record, @Param("example") TenantUserExample example);

    int updateByPrimaryKeySelective(TenantUser record);

    int updateByPrimaryKey(TenantUser record);
}