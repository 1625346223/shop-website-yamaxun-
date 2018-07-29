package com.hwua.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.ProductCategoryDao;
import com.hwua.entity.ProductCategory;
import com.hwua.util.C3P0Util;

public class ProductCategoryDaoImpl implements ProductCategoryDao {

	@Override
	public List<ProductCategory> checkProducCategory() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_product_category";
		return qr.query(sql, new BeanListHandler<ProductCategory>(ProductCategory.class));
	}

}
