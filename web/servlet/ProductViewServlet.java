package com.hwua.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.hwua.entity.Product;
import com.hwua.entity.ProductCategory;
import com.hwua.service.impl.ProductCategoryServiceImpl;
import com.hwua.service.impl.ProductServiceImpl;

public class ProductViewServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id=Integer.parseInt(req.getParameter("productid"));
		ProductServiceImpl psi = new ProductServiceImpl();
		Product product = psi.queryProduct(id);
		
		ProductCategoryServiceImpl pcsi = new ProductCategoryServiceImpl();
		List<ProductCategory> list = pcsi.checkProductCategory();
		List<ProductCategory> parent=new ArrayList<ProductCategory>();
		List<ProductCategory> son=new ArrayList<ProductCategory>();
		for (ProductCategory pc : list) {
			if (pc.getHpc_id()==pc.getHpc_parent_id()) {
				parent.add(pc);	
			}else {
				son.add(pc);
			}
		}
		req.setAttribute("parent", parent);
		req.setAttribute("son", son);
		
		req.setAttribute("productinfo", product);
		req.getRequestDispatcher("productview1").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
