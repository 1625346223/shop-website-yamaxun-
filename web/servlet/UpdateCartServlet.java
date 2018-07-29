package com.hwua.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.entity.Cart;
import com.hwua.entity.Product;
import com.hwua.entity.User;
import com.hwua.service.impl.CartServiceImpl;
import com.hwua.service.impl.ProductServiceImpl;

public class UpdateCartServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long pId = Integer.parseInt(req.getParameter("pId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("login_user");
		if (user==null) {
			resp.getWriter().write("<script type='text/javascript'>alert('请登录账户!')</script>");
			resp.setHeader("refresh", "1;url=login");//定时刷新(重定向)
			return;
		}
		long userId = user.getHu_user_id();
		Cart cart = new Cart(pId, quantity, userId);
		CartServiceImpl csi = new CartServiceImpl();
		ProductServiceImpl psi = new ProductServiceImpl();
		Product p = psi.queryProduct(pId);
		
		csi.updateCart(cart);
		double hp_price = Double.parseDouble(p.getHp_price());
		double money = (double) (hp_price*quantity);
		resp.getWriter().write(""+money);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

}
