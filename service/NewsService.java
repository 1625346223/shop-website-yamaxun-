package com.hwua.service;

import java.util.List;

import com.hwua.entity.News;

public interface NewsService {
	/**
	 * 1.查询新闻
	 * @return
	 */
	public List<News> newsCheck();
	/**
	 * 2.根据标题查询新闻内容
	 * @param title 
	 * @return
	 */
	public News queryNews(long id);
}
