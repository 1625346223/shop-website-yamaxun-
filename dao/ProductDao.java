package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Product;

public interface ProductDao {
	/**
	 * 0.根据id查询单个商品信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Product queryProduct(long id) throws SQLException;
	/**
	 * 1.1查询所有的商品
	 * @return  商品集合
	 */
	public List<Product> queryAllProduct() throws SQLException;
	/**
	 * 1.2查询商品的总个数
	 * @return
	 */
	public long queryProductCount() throws SQLException;
	/**
	 * 1.3商品分页查询
	 * @param currentPage  当前页码
	 * @param pageSize 一页显示多少条记录
	 * @return  这一页的商品集合
	 */
	public List<Product> productPagenation(int currentPage,int pageSize) throws SQLException;
	/**
	 * 2.1查询相同父类的商品
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<Product> querySomeProduct(long id) throws SQLException;
	/**
	 * 2.2查询相同父类的商品的总个数
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public long querySameParentProduct(long id) throws SQLException;
	/**
	 * 2.3导航栏的分类分页查询
	 * @param currentPage
	 * @param pageSize
	 * @param id  父类编号
	 * @return
	 * @throws SQLException
	 */
	public List<Product> productCategoryPagenation(int currentPage,int pageSize,long id) throws SQLException;
	/**
	 * 3.1 超父类的数量
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public long querySameSuperParentProduct(long id) throws SQLException;
	/**
	 * 3.2 超父类的商品数量
	 * @param currentPage
	 * @param pageSize
	 * @param id 超父类的编号
	 * @return
	 * @throws SQLException
	 */
	public List<Product> productParentCategoryPagenation(int currentPage,int pageSize,long id) throws SQLException;
	/**
	 * 4.1 模糊查询条数
	 * @param pname
	 * @return
	 * @throws SQLException
	 */
	public long queryProductMoHu(String pname) throws SQLException ;
	/**
	 * 4.2 模糊查询
	 * @param currentPage
	 * @param pageSize
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<Product> productPagenationMoHu(int currentPage,int pageSize,String pname) throws SQLException;
	/**
	 * 5.修改库存量
	 * @param newStock
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public int updateStock(int newStock,long pid) throws SQLException ;
}
