package com.hwua.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.service.impl.UserServiceImpl;

public class CheckUserEmailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		if (email != null) {
			UserServiceImpl usi = new UserServiceImpl();
			boolean canUse = usi.queryUserByEmail(email);
			resp.getWriter().write(canUse ? "0" : "1");
		} else {
			resp.getWriter().write("<script type='text/javascript'>alert('邮箱为空！')</script>");
			resp.setHeader("refresh", "1;url=view?page=regist");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
