package com.pro.service;

import java.util.List;

import com.pro.entity.SystemRole;
import com.pro.entity.TenantUser;

public interface TenantUserService {

	/**
	 * 通过用户名获取用户信息
	 * 
	 * @param username
	 * @return
	 */
	public TenantUser getByUserName(String username);

	/**
	 * 通过手机号获取用户信息
	 * 
	 * @param phoneno
	 * @return
	 */
	public TenantUser getByUserPhone(String phoneno);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 */
	public void update(TenantUser user);

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	public void save(TenantUser user);

	/**
	 * 重置用户密码
	 * 
	 * @param userid
	 * @param password
	 */
	public void resetUserPassword(String userid, String password);

	/**
	 * 获取用户所有角色
	 * 
	 * @param userid
	 * @return
	 */
	public List<SystemRole> getUserRoles(String userid);

}
