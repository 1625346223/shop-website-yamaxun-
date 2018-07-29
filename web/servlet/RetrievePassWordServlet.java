package com.hwua.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.User;
import com.hwua.service.impl.UserServiceImpl;

public class RetrievePassWordServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("userName");
		String email = req.getParameter("email");
		User user = null;
		if (uname!=null && email!=null) {
			UserServiceImpl usi = new UserServiceImpl();
			user = usi.queryUserByNameAndEmail(uname, email);
		}else {
			resp.getWriter().write("<script type='text/javascript'>alert('信息不能为空!')</script>");
			resp.setHeader("refresh", "1;url=view?page=login");// 一秒钟定时刷新到url路径处
			return;
		}
		if (user!=null) {
			resp.getWriter().write("<script type='text/javascript'>alert('密码为："+user.getHu_password()+"!')</script>");
			resp.setHeader("refresh", "1;view?page=login");//定时刷新(重定向)
		}else {
			resp.getWriter().write("<script type='text/javascript'>alert('找不到用户信息!')</script>");
			resp.setHeader("refresh", "1;view?page=login");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

}
