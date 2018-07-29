package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.impl.NewsDaoImpl;
import com.hwua.entity.News;
import com.hwua.service.NewsService;

public class NewsServiceImpl implements NewsService {

	@Override
	public List<News> newsCheck() {
		NewsDaoImpl ndi = new NewsDaoImpl();
		List<News> nc = null;
		try {
			nc = ndi.newsCheck();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nc;
	}

	@Override
	public News queryNews(long id) {
		NewsDaoImpl ndi = new NewsDaoImpl();
		News news = null;
		try {
			news = ndi.queryNews(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}

}
