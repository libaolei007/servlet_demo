package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @description:
 * @author: libl
 * @date: 2018年10月25日 上午11:34:55
 */
@WebFilter("/*") // "/*"指过滤器适用于所有的 Servlet
public class FilterDemo implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 输出站点名称
		System.out.println("访问请求进入过滤器");
		// http://localhost:8080/servlet_demo/ServletDemo?name=123
		if ("123".equals(req.getParameter("name"))) {
			// 设置返回内容类型
			resp.setContentType("text/html;charset=GBK");
			// 在页面输出响应信息
			PrintWriter out = resp.getWriter();
			out.print("<b>name为123正确，请求被拦截，访问web资源</b>");
			// 把请求传回过滤链
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig chain) throws ServletException {
		// 获取初始化参数
		String site = chain.getInitParameter("Site");
		// 输出初始化参数
		System.out.println("项目启动过滤器加载初始化参数" + site);
	}

}
