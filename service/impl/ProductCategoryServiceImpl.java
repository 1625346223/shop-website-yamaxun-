package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.impl.ProductCategoryDaoImpl;
import com.hwua.entity.ProductCategory;
import com.hwua.service.ProductCategoryService;

public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Override
	public List<ProductCategory> checkProductCategory() {
		ProductCategoryDaoImpl pcdi = new ProductCategoryDaoImpl();
		List<ProductCategory> list = null;
		try {
			list = pcdi.checkProducCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
