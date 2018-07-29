package com.hwua.service;

import java.util.List;

import com.hwua.entity.PageModel;
import com.hwua.entity.Product;

public interface ProductService {
	/**
	 * 1.查询所有的商品
	 * @return 商品集合
	 */
	public List<Product> queryAllProduct();
	
	/**
	 * 2.分页查询商品
	 * @param currentPage  当前页码
	 * @param pageSize 一页显示多少个商品
	 * @return 分页模型(分页所需要的数据)
	 */
	public PageModel<Product> productPagenation(int currentPage,int pageSize);
	/**
	 * 3.分页查询相同父类的商品
	 * @param currentPage
	 * @param pageSize
	 * @param id
	 * @return
	 */
	public PageModel<Product> productPagenation2(int currentPage,int pageSize,long id);
	/**
	 * 4.查询单个商品信息
	 * @param id
	 * @return
	 */
	public Product queryProduct(long id);
	/**
	 * 5.分页查询相同超父类的商品
	 * @param currentPage
	 * @param pageSize
	 * @param id
	 * @return
	 */
	public PageModel<Product> productPagenation3(int currentPage,int pageSize,long id);
	/**
	 * 6.模糊
	 * @param currentPage
	 * @param pageSize
	 * @param pname
	 * @return
	 */
	public PageModel<Product> productPagenationMoHu(int currentPage,int pageSize,String pname) ;
	/**
	 * 7.修改库存量
	 * @param newStock
	 * @param pid
	 * @return
	 */
	public int updateStock(int newStock,long pid);
}
