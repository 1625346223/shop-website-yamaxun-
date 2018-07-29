package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.impl.ProductDaoImpl;
import com.hwua.entity.PageModel;
import com.hwua.entity.Product;
import com.hwua.service.ProductService;

public class ProductServiceImpl implements ProductService {
	// 1.查询所有的商品
	@Override
	public List<Product> queryAllProduct() {
		ProductDaoImpl pdi = new ProductDaoImpl();
		List<Product> list = null;
		try {
			list = pdi.queryAllProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2.分页显示商品
	@Override
	public PageModel<Product> productPagenation(int currentPage, int pageSize) {
		ProductDaoImpl pdi = new ProductDaoImpl();
		PageModel<Product> pageModel = null;
		try {
			// 1.获取商品总个数
			long total = pdi.queryProductCount();
			// 2.计算出totalPage
			int totalPage = (int) (total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
			// 3.获取这一页的商品集合
			List<Product> pageList = pdi.productPagenation(currentPage, pageSize);
			// 4.封装pageModel对象并返回
			pageModel = new PageModel<>(currentPage, pageSize, total, totalPage, pageList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	@Override
	public PageModel<Product> productPagenation2(int currentPage, int pageSize,long id) {
		ProductDaoImpl pdi = new ProductDaoImpl();
		PageModel<Product> pageModel = null;
		try {
			// 1.获取商品总个数
			long total = pdi.querySameParentProduct(id);
			// 2.计算出totalPage
			int totalPage = (int) (total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
			// 3.获取这一页的商品集合
			List<Product> pageList = pdi.productCategoryPagenation(currentPage, pageSize, id);
			// 4.封装pageModel对象并返回
			pageModel = new PageModel<>(currentPage, pageSize, total, totalPage, pageList,id,0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	@Override
	public Product queryProduct(long id) {
		ProductDaoImpl pdi = new ProductDaoImpl();
		Product product = null;
		try {
			product = pdi.queryProduct(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public PageModel<Product> productPagenation3(int currentPage, int pageSize, long id) {
		ProductDaoImpl pdi = new ProductDaoImpl();
		PageModel<Product> pageModel = null;
		try {
			// 1.获取商品总个数
			long total = pdi.querySameSuperParentProduct(id);
			// 2.计算出totalPage
			int totalPage = (int) (total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
			// 3.获取这一页的商品集合
			List<Product> pageList = pdi.productParentCategoryPagenation(currentPage, pageSize, id);
			// 4.封装pageModel对象并返回
			pageModel = new PageModel<>(currentPage, pageSize, total, totalPage, pageList,0,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	@Override
	public PageModel<Product> productPagenationMoHu(int currentPage, int pageSize, String pname) {
		ProductDaoImpl pdi = new ProductDaoImpl();
		PageModel<Product> pageModel = null;
		try {
			// 1.获取商品总个数
			long total = pdi.queryProductMoHu(pname);
			// 2.计算出totalPage
			int totalPage = (int) (total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
			// 3.获取这一页的商品集合
			List<Product> pageList = pdi.productPagenationMoHu(currentPage, pageSize, pname);
			// 4.封装pageModel对象并返回
			pageModel = new PageModel<>(currentPage, pageSize, total, totalPage, pageList,0,0,pname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageModel;
	}

	@Override
	public int updateStock(int newStock, long pid) {
		ProductDaoImpl pdi = new ProductDaoImpl();
		int rows = 0;
		try {
			rows = pdi.updateStock(newStock, pid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rows;
	}
}
