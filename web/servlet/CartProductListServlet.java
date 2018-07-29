package com.hwua.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.entity.NewCart;
import com.hwua.entity.User;
import com.hwua.service.impl.CartServiceImpl;

public class CartProductListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("login_user");
		if (user==null) {
			resp.getWriter().write("<script type='text/javascript'>alert('亲，您还没有登录!')</script>");
			resp.setHeader("refresh", "1;url=view?page=login");
			return;
		}
		long userId = user.getHu_user_id();
		CartServiceImpl csi = new CartServiceImpl();
		List<NewCart> list = csi.queryProductInCart(userId);
		req.setAttribute("productListInCart", list);
		req.getRequestDispatcher("view?page=shopping").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
