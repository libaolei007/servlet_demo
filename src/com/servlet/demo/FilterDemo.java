package com.servlet.demo;

import java.io.IOException;

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
@WebFilter("/*")
public class FilterDemo implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// 输出站点名称
		System.out.println("访问请求进入过滤器");
		// 把请求传回过滤链
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// 获取初始化参数
		String site = arg0.getInitParameter("Site");
		// 输出初始化参数
		System.out.println("项目启动过滤器加载初始化参数" + site);
	}

}
