package com.hwua.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.Comment;
import com.hwua.entity.ProductCategory;
import com.hwua.service.impl.CommentServiceImpl;
import com.hwua.service.impl.ProductCategoryServiceImpl;

public class CommentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommentServiceImpl csi = new CommentServiceImpl();
		List<Comment> list1 = csi.queryComment();
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
		req.setAttribute("commentList", list1);
		req.getRequestDispatcher("view?page=guestbook").forward(req, resp);
	}
}
