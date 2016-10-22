package com.pro.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("index")
	public ModelAndView indexPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping("default")
	public ModelAndView defaultPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("default");
		return modelAndView;
	}

	@RequestMapping("default1")
	public ModelAndView default1Page(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("default1");
		return modelAndView;
	}

	@RequestMapping("default2")
	public ModelAndView default2Page(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("default2");
		return modelAndView;
	}

	@RequestMapping("default3")
	public ModelAndView default3Page(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("default3");
		return modelAndView;
	}

	@RequestMapping("default4")
	public ModelAndView default4Page(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("default4");
		return modelAndView;
	}

	@RequestMapping("default5")
	public ModelAndView default5Page(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("default5");
		return modelAndView;
	}

	@RequestMapping("default6")
	public ModelAndView default6Page(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("default6");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("service")
	public Map<String, Object> service(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", "value");
		return map;
	}

}
