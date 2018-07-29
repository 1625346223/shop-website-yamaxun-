package com.hwua.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * C3P0工具(产生数据源,获取连接对象,DBUtil查询对象)
 */
public class C3P0Util {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("获取数据库连接对象失败");
		}
		return conn;
	}
	//通过c3p0获取DBUtil的查询对象
	public static QueryRunner getQueryRunner(){
		return new QueryRunner(dataSource);
	}
	
}
