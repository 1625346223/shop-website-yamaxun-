package com.hwua.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤器(post请求)
 */
public class EncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//处理请求和响应的乱码
		request.setCharacterEncoding("utf-8");//只能处理post请求
		response.setContentType("text/html;charset=utf-8");//get/post响应处理
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
