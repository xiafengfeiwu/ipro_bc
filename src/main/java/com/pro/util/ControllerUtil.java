package com.pro.util;

import java.util.ArrayList;
import java.util.List;

import com.pro.entity.SystemMenu;
import com.pro.model.SystemMenuModel;

public class ControllerUtil {
	/***
	 * 初始化菜单Dom数据
	 * 
	 * @param menus
	 * @return
	 */
	public static String initMenuDom(List<SystemMenu> menus) {
		List<SystemMenuModel> menuModels = initMenuModels(menus);
		StringBuffer sb = new StringBuffer();
		for (SystemMenuModel menuModel : menuModels) {
			sb.append("<li>");
			// 没有子节点
			if (menuModel.getChilds() == null || menuModel.getChilds().isEmpty()) {
				sb.append("<a href=\"");
				sb.append(menuModel.getMenu().getMenuAddress());
				sb.append("\" class=\"J_menuItem\"><i class=\"");
				sb.append(menuModel.getMenu().getMenuIcon());
				sb.append("\"></i><span class=\"nav-label\">");
				sb.append(menuModel.getMenu().getMenuName());
				sb.append("</span></a>");
			} else {
				sb.append("<a href=\"javascript:;\"><i class=\"");
				sb.append(menuModel.getMenu().getMenuIcon());
				sb.append("\"></i><span class=\"nav-label\">");
				sb.append(menuModel.getMenu().getMenuName());
				sb.append("</span><span class=\"fa arrow\"></span></a><ul class=\"nav nav-second-level\">");
				// 遍历二级节点
				for (SystemMenuModel menuModel2 : menuModel.getChilds()) {
					sb.append("<li>");
					// 没有子节点
					if (menuModel2.getChilds() == null || menuModel2.getChilds().isEmpty()) {
						sb.append("<a class=\"J_menuItem\" href=\"");
						sb.append(menuModel2.getMenu().getMenuAddress());
						sb.append("\">");
						sb.append(menuModel2.getMenu().getMenuName());
						sb.append("</a>");
					} else {
						sb.append("<a href=\"javascript:;\">");
						sb.append(menuModel2.getMenu().getMenuName());
						sb.append("<span class=\"fa arrow\"></span></a><ul class=\"nav nav-third-level\">");
						// 遍历三级节点
						for (SystemMenuModel menuModel3 : menuModel2.getChilds()) {
							sb.append("<li><a class=\"J_menuItem\" href=\"");
							sb.append(menuModel3.getMenu().getMenuAddress());
							sb.append("\">");
							sb.append(menuModel3.getMenu().getMenuName());
							sb.append("</a></li>");
						}
						sb.append("</ul>");
					}
					sb.append("</li>");
				}
				sb.append("</ul>");
			}
			sb.append("</li>");
		}
		return sb.toString();
	}

	/***
	 * 初始化菜单结构数据
	 * 
	 * @param menus
	 * @return
	 */
	public static List<SystemMenuModel> initMenuModels(List<SystemMenu> menus) {
		List<SystemMenuModel> menuModels = new ArrayList<>();
		for (SystemMenu menu1 : menus) {
			// 是根节点
			if ("level1".equals(menu1.getMenuLevel())) {
				// 初始化根节点数据对象
				SystemMenuModel menuModel1 = new SystemMenuModel();
				menuModel1.setMenu(menu1);
				// 获取二级节点
				List<SystemMenuModel> menuModels1 = new ArrayList<>();
				for (SystemMenu menu2 : menus) {
					// 遍历 获取二级节点
					if (menu1.getMenuId().equals(menu2.getParentMenuId())) {
						// 初始化二级节点
						SystemMenuModel menuModel2 = new SystemMenuModel();
						menuModel2.setMenu(menu2);
						// 获取三级节点
						List<SystemMenuModel> menuModels2 = new ArrayList<>();
						for (SystemMenu menu3 : menus) {
							// 是三级节点
							if (menu2.getMenuId().equals(menu3.getParentMenuId())) {
								// 初始化三级节点
								SystemMenuModel menuModel3 = new SystemMenuModel();
								menuModel3.setMenu(menu3);
								// 加入二级节点子节点数组
								menuModels2.add(menuModel3);
							}
						}
						// 设置二级节点子节点数组
						menuModel2.setChilds(menuModels2);
						menuModels1.add(menuModel2);
					}
				}
				// 设置一级节点数组
				menuModel1.setChilds(menuModels1);
				menuModels.add(menuModel1);
			}
		}
		return menuModels;
	}
}
