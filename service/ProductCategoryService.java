package com.hwua.service;

import java.util.List;

import com.hwua.entity.ProductCategory;

public interface ProductCategoryService {
	/**
	 * 1.查询商品分类列表
	 * @return列表
	 */
	public List<ProductCategory> checkProductCategory();
}
