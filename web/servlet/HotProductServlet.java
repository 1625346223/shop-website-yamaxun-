package com.hwua.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.hwua.entity.Product;
import com.hwua.service.impl.ProductServiceImpl;

public class HotProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductServiceImpl psi = new ProductServiceImpl();
		List<Product> list = psi.queryAllProduct();
		List<Product> newlist = new ArrayList<Product>();
		for (int i = 0; i < 6; i++) {
			int num = (int)(Math.random()*60)+1;
			newlist.add(list.get(num));
		}
		req.setAttribute("hotlist", newlist);
		req.getRequestDispatcher("view?page=index").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
