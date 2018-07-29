package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.News;

public interface NewsDao {
	/**
	 * 1.查询新闻版面内容
	 * @return 新闻list
	 * @throws SQLException 异常
	 */
	public List<News> newsCheck() throws SQLException ;
	/**
	 * 2.查询新闻内容
	 * @param title
	 * @return
	 * @throws SQLException
	 */
	public News queryNews(long id) throws SQLException ;
		
	
}
