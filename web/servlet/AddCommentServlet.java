package com.hwua.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.Comment;
import com.hwua.service.impl.CommentServiceImpl;

public class AddCommentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("guestName");
		String title = req.getParameter("guestTitle");
		String content = req.getParameter("guestContent");
		String time = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		Comment comment = new Comment(content, time, name, title);
		CommentServiceImpl csi = new CommentServiceImpl();
		int rows = csi.insertComment(comment);
		if (rows>0) {
			resp.getWriter().write("<script type='text/javascript'>alert('留言成功!')</script>");
			resp.setHeader("refresh", "0.1;url=guestbook");
		}else {
			resp.getWriter().write("<script type='text/javascript'>alert('留言失败!')</script>");
			resp.setHeader("refresh", "0.1;url=guestbook");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
