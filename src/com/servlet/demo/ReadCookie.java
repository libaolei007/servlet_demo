package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: libl
 * @date: 2019年2月12日 下午5:07:39
 */
@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取与该域相关的 Cookie 的数组
		Cookie[] cookies = req.getCookies();
		// 设置响应内容类型
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String title = "Delete Cookie Example";
		String docType = "<!DOCTYPE html>\n";
		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
		if (cookies != null) {
			out.println("<h2>Cookie 名称和值</h2>");
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if ((cookie.getName()).compareTo("name") == 0) {
					cookie.setMaxAge(0); // 设置过期时间 默认情况下，-1 表示 cookie 将持续下去，直到浏览器关闭
					resp.addCookie(cookie);
					out.print("已删除的 cookie：" + cookie.getName() + "<br/>");
				}
				out.print("名称：" + cookie.getName() + "，");
				out.print("值：" + URLDecoder.decode(cookie.getValue(), "utf-8") + " <br/>");
			}
		} else {
			out.println("<h2 class=\"tutheader\">No Cookie founds</h2>");
		}
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
