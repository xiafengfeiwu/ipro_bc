package com.pro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.TenantUserMapper;
import com.pro.entity.SystemRole;
import com.pro.entity.TenantUser;
import com.pro.entity.TenantUserExample;
import com.pro.service.TenantUserService;

@Service("tenantUserService")
public class TenantUserServiceImpl implements TenantUserService {

	@Autowired
	TenantUserMapper tenantUserMapper;

	@Override
	public TenantUser getByUserName(String username) {
		TenantUserExample example = new TenantUserExample();
		example.createCriteria().andUserNameEqualTo(username);
		List<TenantUser> users = tenantUserMapper.selectByExample(example);
		if (users != null && !users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public TenantUser getByUserPhone(String phoneno) {
		TenantUserExample example = new TenantUserExample();
		example.createCriteria().andUserPhoneEqualTo(phoneno);
		List<TenantUser> users = tenantUserMapper.selectByExample(example);
		if (users != null && !users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public void update(TenantUser user) {
		tenantUserMapper.updateByPrimaryKey(user);
	}

	@Override
	public void save(TenantUser user) {
		tenantUserMapper.insert(user);
	}

	@Override
	public void resetUserPassword(String userid, String password) {
		TenantUser user = new TenantUser();
		user.setUserId(userid);
		user.setUserPassword(password);
		tenantUserMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<SystemRole> getUserRoles(String userid) {
		return null;
	}

}
