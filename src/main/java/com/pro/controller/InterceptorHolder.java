package com.pro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorHolder extends HandlerInterceptorAdapter {
	private final Logger logger = Logger.getLogger(this.getClass());
	private ThreadLocal<Long> exeStSecond = new ThreadLocal<Long>() {
		public Long initialValue() {
			return 0l;
		}
	};

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 记录执行开始时间
		exeStSecond.set(System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 数据查询处理完成时间
		long exeSecond = System.currentTimeMillis() - exeStSecond.get();
		logger.debug("ExeSecond: " + exeSecond);
		if (modelAndView != null) {
			modelAndView.addObject("EXE_SECOND", exeSecond);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 页面渲染完成时间
		long renderingSecond = System.currentTimeMillis() - exeStSecond.get();
		logger.debug("RenderingSecond: " + renderingSecond);
	}

}