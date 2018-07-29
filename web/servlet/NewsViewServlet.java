package com.hwua.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.News;
import com.hwua.service.impl.NewsServiceImpl;

public class NewsViewServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Integer.parseInt(req.getParameter("newsid"));
		NewsServiceImpl nsi = new NewsServiceImpl();
		List<News> list = nsi.newsCheck();
		News news = nsi.queryNews(id);
		req.setAttribute("news1", news);
		req.setAttribute("newsList", list);
		req.getRequestDispatcher("view?page=news_view").forward(req, resp);
	}
}
