package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @description:
 * @author: libl  
 * @date: 2019年2月12日 下午5:07:25
 */
@WebServlet("/SaveCookie")
public class SaveCookie extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//为名字和姓氏创建Cookie
		Cookie name = new Cookie("name",URLEncoder.encode(req.getParameter("name"), "utf-8"));
		Cookie url = new Cookie("url", req.getParameter("url"));
		// 为两个Cookie设置过期时间为60秒
		name.setMaxAge(60);
		url.setMaxAge(60);
		// 在响应头中添加两个Cookie
		resp.addCookie(name);
		resp.addCookie(url);
		// 设置响应内容类型
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		  String title = "设置 Cookie 实例";
	        String docType = "<!DOCTYPE html>\n";
	        out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>站点名：</b>："
	                + req.getParameter("name") + "\n</li>" +
	                "  <li><b>站点 URL：</b>："
	                + req.getParameter("url") + "\n</li>" +
	                "</ul>\n" +
	                "</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPostdoPostdoPost");
		doGet(req, resp);
	}
	
}
