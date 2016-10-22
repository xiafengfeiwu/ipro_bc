package com.pro.service;

import java.util.List;

import com.pro.entity.SystemMenu;
import com.pro.entity.SystemMenuExample;

public interface SystemMenuService {
	long countByExample(SystemMenuExample example);
	
    List<SystemMenu> selectByExample(SystemMenuExample example);
}
