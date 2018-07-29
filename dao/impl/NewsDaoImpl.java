package com.hwua.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.NewsDao;
import com.hwua.entity.News;
import com.hwua.util.C3P0Util;

public class NewsDaoImpl implements NewsDao {

	@Override
	public List<News> newsCheck() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_news";
		return qr.query(sql, new BeanListHandler<News>(News.class));
	}

	@Override
	public News queryNews(long id) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_news where hn_id=?";
		return qr.query(sql, new BeanHandler<News>(News.class),id);
	}

}
