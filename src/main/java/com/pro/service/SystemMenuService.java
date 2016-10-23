package com.pro.service;

import java.util.List;

import com.pro.entity.SystemMenu;

public interface SystemMenuService {

	/***
	 * 获取系统一级菜单
	 * 
	 * @return
	 */
	List<SystemMenu> findRootMenus();

	/***
	 * 获取系统所有的菜单数据
	 * 
	 * @return
	 */
	List<SystemMenu> findAllMenus();

}
