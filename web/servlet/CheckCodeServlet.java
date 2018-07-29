package com.hwua.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String veryCode = req.getParameter("veryCode");
		if (veryCode != null) {
			HttpSession session = req.getSession(false);
			int yanCode = Integer.parseInt((String) session.getAttribute("validateCode"));
			resp.getWriter().write((yanCode == Integer.parseInt(veryCode)) ? "1" : "0");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
