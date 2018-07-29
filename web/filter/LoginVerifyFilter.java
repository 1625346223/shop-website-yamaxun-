package com.hwua.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录验证过滤器
 */
public class LoginVerifyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1.需要将父类对象转换成子类对象(下转型:不安全)
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			//2.需要进行登录验证
			HttpSession session = req.getSession(false);//获取session
			if (session==null || session.getAttribute("userName")==null) {
				resp.getWriter().write("<script type='text/javascript'>alert('未登录,请先登录!')</script>");
				resp.setHeader("refresh", "1;url=view?page=login");
			}else{//已经登录成功(放行)
				chain.doFilter(request, response);
			}
		}
		
		
	}

	@Override
	public void destroy() {
	}

}
