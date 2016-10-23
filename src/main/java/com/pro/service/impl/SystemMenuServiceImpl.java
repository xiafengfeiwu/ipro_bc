package com.pro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.SystemMenuMapper;
import com.pro.entity.SystemMenu;
import com.pro.entity.SystemMenuExample;
import com.pro.entity.SystemMenuExample.Criteria;
import com.pro.service.SystemMenuService;

@Service("systemMenuService")
public class SystemMenuServiceImpl implements SystemMenuService {

	@Autowired
	private SystemMenuMapper systemMenuMapper;

	@Override
	public List<SystemMenu> findAllMenus() {
		SystemMenuExample example = new SystemMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andMenuStatusEqualTo("y");
		example.setOrderByClause("menu_sort_no asc");
		return systemMenuMapper.selectByExample(example);
	}

	@Override
	public List<SystemMenu> findRootMenus() {
		SystemMenuExample example = new SystemMenuExample();
		example.createCriteria().andMenuLevelEqualTo("level1");
		example.setOrderByClause("menu_sort_no asc");
		return systemMenuMapper.selectByExample(example);
	}
}
