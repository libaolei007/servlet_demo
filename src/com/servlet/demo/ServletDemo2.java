package com.servlet.demo;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @description: 继承GenericServlet
 * @author: libl
 * @date: 2018年10月23日 下午2:58:08
 */

public class ServletDemo2 extends GenericServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("继承GenericServlet service()...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("继承GenericServlet init()...");
	}
}
