package com.pro.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pro.entity.SystemMenu;
import com.pro.model.SystemMenuModel;
import com.pro.service.SystemMenuService;
import com.pro.util.ControllerUtil;
import com.pro.util.ObjectId;
import com.pro.util.TinifyUtil;
import com.tinify.Tinify;

@Controller
@RequestMapping("sys")
public class SystemController {
	private final Logger logger = Logger.getLogger(this.getClass());
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

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public ModelAndView uploadFilePage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("sys/upload");
		return modelAndView;
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public ModelAndView uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			logger.debug("deal with upload file!");
		}

		String path = request.getServletContext().getInitParameter("WEB_UPLOAD_PATH");

		String originalFilename = file.getOriginalFilename();
		String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
		String filename = ObjectId.getId() + "." + type;

		DateFormat format = new SimpleDateFormat("yyyyMM");
		String dateDir = format.format(new Date());

		String separator = File.separator;

		try {
			String filePath = path + separator + dateDir + separator + filename;
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath));
		} catch (IOException e) {
		}

		ModelAndView modelAndView = new ModelAndView("redirect:/sys/upload");
		return modelAndView;
	}
}
