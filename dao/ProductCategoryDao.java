package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.ProductCategory;

public interface ProductCategoryDao {
	/**
	 * 1.查询商品分类列表
	 * @return
	 * @throws SQLException
	 */
	public List<ProductCategory> checkProducCategory() throws SQLException;
}
