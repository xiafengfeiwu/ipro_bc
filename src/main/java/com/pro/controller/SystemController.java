package com.pro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pro.entity.SystemMenu;
import com.pro.model.SystemMenuModel;
import com.pro.service.SystemMenuService;
import com.pro.util.ControllerUtil;

@Controller
@RequestMapping("sys")
public class SystemController {

	@Autowired
	SystemMenuService systemMenuService;

	@RequestMapping("menu")
	public ModelAndView menuPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("sys/menu");
		// 从数据库中查询菜单数据
		List<SystemMenu> menus = systemMenuService.findAllMenus();
		// 初始化菜单结构
		List<SystemMenuModel> menuModels = ControllerUtil.initMenuModels(menus);
		modelAndView.addObject("menuModels", menuModels);
		return modelAndView;
	}

}
