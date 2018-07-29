package com.hwua.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hwua.dao.ProductDao;
import com.hwua.entity.Product;
import com.hwua.util.C3P0Util;

public class ProductDaoImpl implements ProductDao {
	/**
	 * 第一组分页
	 */
	@Override
	public List<Product> queryAllProduct() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_product";
		return qr.query(sql, new BeanListHandler<Product>(Product.class));
	}

	@Override
	public long queryProductCount() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select count(*) from hwua_product";
		return (long) qr.query(sql, new ScalarHandler<>());
	}

	// 3.分页查询
	@Override
	public List<Product> productPagenation(int currentPage, int pageSize) throws SQLException {
		// 1.计算起始行start
		int start = (currentPage - 1) * pageSize;
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_product limit ?,?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class), start, pageSize);
	}
	/**
	 * 第二组分页
	 */

	@Override
	public List<Product> querySomeProduct(long id) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_product where HPC_CHILD_ID=?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class),id);
	}

	@Override
	public long querySameParentProduct(long id) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select count(*) from hwua_product where HPC_CHILD_ID=?";
		return (long) qr.query(sql, new ScalarHandler<>(),id);
		
	}

	@Override
	public List<Product> productCategoryPagenation(int currentPage, int pageSize, long id) throws SQLException {
		int start = (currentPage - 1) * pageSize;
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_product where HPC_CHILD_ID=? limit ?,?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class), id, start, pageSize);
	}
	/**
	 * 查询单个商品的信息
	 */
	@Override
	public Product queryProduct(long id) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_product where HP_ID=?";
		return qr.query(sql, new BeanHandler<Product>(Product.class),id);
	}
	//第三组分页：超父类
	@Override
	public long querySameSuperParentProduct(long id) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select count(*) from hwua_product where HPC_ID=?";
		return (long) qr.query(sql, new ScalarHandler<>(),id);
	}

	@Override
	public List<Product> productParentCategoryPagenation(int currentPage, int pageSize, long id) throws SQLException {
		int start = (currentPage - 1) * pageSize;
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_product where HPC_ID=? limit ?,?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class), id, start, pageSize);
	}
	//第四组分类：模糊查询
	@Override
	public long queryProductMoHu(String pname) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select count(*) from hwua_product where HP_NAME LIKE ? or hp_description like ?";
		return (long) qr.query(sql, new ScalarHandler<>(),"%"+pname+"%","%"+pname+"%");
	}
	@Override
	public List<Product> productPagenationMoHu(int currentPage, int pageSize, String pname) throws SQLException {
		int start = (currentPage - 1) * pageSize;
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_product where HP_NAME like ? or hp_description like ? limit ?,?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class), "%"+pname+"%","%"+pname+"%", start, pageSize);
	}

	@Override
	public int updateStock(int newStock,long pid) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "update hwua_product set hp_stock=? WHERE hp_id=?";
		return qr.update(sql,newStock,pid);
	}

	
}
