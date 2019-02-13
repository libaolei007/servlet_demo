package com.servlet.demo.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 验证登录
 * @author: libl
 * @date: 2019年2月13日 上午10:30:10
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("UTF-8"); // 如果是中文验证码则需要处理中文编码的问题

		// 处理注册请求之前，校验验证码是否有效
		String c_checkcode = request.getParameter("checkcode");
		String s_checkcode = (String) request.getSession().getAttribute("checkcode");
		System.out.println(c_checkcode);
		System.out.println(s_checkcode);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String title = "Session 验证码 实例";
		String docType = "<!DOCTYPE html>\n";
		if (c_checkcode != null && s_checkcode != null && c_checkcode.toLowerCase().equals(s_checkcode.toLowerCase())) {
			System.out.println("验证码成功，处理注册请求！");
			out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
					+ "<body bgcolor=\"#f0f0f0\">\n" + "<p>验证码成功，处理注册请求！</p>" + "</body></html>");
		} else {
			System.out.println("验证码验证失败！");
			out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
					+ "<body bgcolor=\"#f0f0f0\">\n" + "<p>验证码验证失败！</p>" + "</body></html>");
		}
		request.getSession().setMaxInactiveInterval(0);
	}
}
