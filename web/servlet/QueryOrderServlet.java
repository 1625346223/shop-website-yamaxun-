package com.hwua.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.hwua.entity.NewOrder;
import com.hwua.entity.NewOrderListBody;
import com.hwua.entity.NewOrderListHead;
import com.hwua.entity.Order;
import com.hwua.entity.OrderDetail;
import com.hwua.entity.User;
import com.hwua.service.impl.OrderDetailServiceImpl;
import com.hwua.service.impl.OrderServiceImpl;

public class QueryOrderServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("login_user");
		long userId = user.getHu_user_id();
		OrderServiceImpl osi = new OrderServiceImpl();
		
		List<NewOrderListHead> orderListHead = osi.queryAllOrder1(userId);
		List<NewOrderListBody> orderListBody = osi.queryAllOrder2(userId);
		
		req.setAttribute("listHead", orderListHead);
		req.setAttribute("listBody", orderListBody);
		req.getRequestDispatcher("view?page=orders_view").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
