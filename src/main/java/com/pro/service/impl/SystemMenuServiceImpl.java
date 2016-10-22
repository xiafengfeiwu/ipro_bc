package com.pro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.SystemMenuMapper;
import com.pro.entity.SystemMenu;
import com.pro.entity.SystemMenuExample;
import com.pro.service.SystemMenuService;

@Service("systemMenuService")
public class SystemMenuServiceImpl implements SystemMenuService {

	@Autowired
	private SystemMenuMapper systemMenuMapper;

	@Override
	public long countByExample(SystemMenuExample example) {

		return systemMenuMapper.countByExample(example);
	}

	@Override
	public List<SystemMenu> selectByExample(SystemMenuExample example) {
		return systemMenuMapper.selectByExample(example);
	}

}
