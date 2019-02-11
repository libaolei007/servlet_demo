package com.servlet.demo;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @description: 实现Servlet接口
 * @author: libl
 * @date: 2018年10月23日 下午2:58:08
 */

public class ServletDemo1 implements Servlet {

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("实现Servlet接口 init()...");
		System.out.println(arg0.getServletName());
		System.out.println(arg0.getInitParameter("default"));
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println(" 实现Servlet接口 service()...");

	}

	// 生命周期方法:当Servlet被销毁时执行该方法 当停止tomcat时也就销毁的servlet。
	@Override
	public void destroy() {
		System.out.println(" 实现Servlet接口 destroy()...");
	}
}
