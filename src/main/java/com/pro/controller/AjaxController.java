package com.pro.controller;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.pro.entity.SystemMenu;
import com.pro.model.SystemMenuModel;
import com.pro.service.SystemMenuService;
import com.pro.util.MenuUtil;

@Controller
@RequestMapping(value = "ajax")
public class AjaxController {
	private final Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	SystemMenuService systemMenuService;
	@Autowired
	private Producer captchaProducer;

	@RequestMapping(value = "verifyhandler")
	public void verifyhandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = captchaProducer.createText();
		logger.debug("当前图片验证码：" + capText);
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}

	@ResponseBody
	@RequestMapping("menualldata")
	public Map<String, Object> menualldata(HttpServletRequest request) {
		Map<String, Object> data = new HashMap<>();
		// 从数据库中查询菜单数据
		List<SystemMenu> menus = systemMenuService.findAllMenus();
		if (menus == null || menus.isEmpty()) {
			return data;
		}
		List<SystemMenuModel> menuModels = MenuUtil.initMenuModels(menus);

		List<Map<String, Object>> roots = new ArrayList<>();
		Map<String, Object> rootnode = null;
		Map<String, Object> additionalparameter = null;
		List<Map<String, Object>> childnodes = new ArrayList<>();
		Map<String, Object> childnode = null;
		Map<String, Object> additionalchildparameter = null;
		List<Map<String, Object>> sonnodes = new ArrayList<>();
		Map<String, Object> sonnode = null;
		Map<String, Object> additionalsonparameter = null;
		
		for (SystemMenuModel menuModel : menuModels) {
			rootnode = new HashMap<>();
			rootnode.put("name", "<i class=\"" + menuModel.getMenu().getMenuIcon() + "\"></i> " + menuModel.getMenu().getMenuName());
			additionalparameter = new HashMap<>();
			additionalparameter.put("id", menuModel.getMenu().getMenuId());
			if (menuModel.getChilds() != null && !menuModel.getChilds().isEmpty()) {
				// 有子节点
				rootnode.put("type", "folder");
				for(SystemMenuModel childModel : menuModel.getChilds()){
					childnode = new HashMap<>();
					childnode.put("name", "<i class=\"" + childModel.getMenu().getMenuIcon() + "\"></i> " + childModel.getMenu().getMenuName());
					additionalchildparameter = new HashMap<>();
					additionalchildparameter.put("id", childModel.getMenu().getMenuId());
					if(childModel.getChilds() != null && !childModel.getChilds().isEmpty()){
						// 有子节点
						childnode.put("type", "folder");
						for(SystemMenuModel sonModel : childModel.getChilds()){
							sonnode = new HashMap<>();
							sonnode.put("name", "<i class=\"" + sonModel.getMenu().getMenuIcon() + "\"></i> " + sonModel.getMenu().getMenuName());
							sonnode.put("type", "item");
							additionalsonparameter = new HashMap<>();
							additionalsonparameter.put("id", sonModel.getMenu().getMenuId());
							sonnode.put("additionalParameters", additionalsonparameter);
							sonnodes.add(sonnode);
						}
						additionalchildparameter.put("children", sonnodes);
						childnode.put("additionalParameters", additionalchildparameter);
					} else {
						// 无子节点
						childnode.put("type", "item");
						childnode.put("additionalParameters", additionalchildparameter);
					}
					childnodes.add(childnode);
				}
				additionalparameter.put("children", childnodes);
				rootnode.put("additionalParameters", additionalparameter);
			} else {
				// 无子节点
				rootnode.put("type", "item");
				rootnode.put("additionalParameters", additionalparameter);
			}
			roots.add(rootnode);
		}
		data.put("data", roots);
		return data;
	}
}
