package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Cart;
import com.hwua.entity.NewCart;

public interface CartDao {
	/**
	 * 0.查询数据库中是否有重复商品的数据
	 * @param cart
	 * @return
	 * @throws SQLException
	 */
	public Cart queryCart(Cart cart) throws SQLException;
	/**
	 * 1.添加到购物车
	 * @param cart
	 * @return
	 * @throws SQLException
	 */
	public int insertCart(Cart cart) throws SQLException;
	/**
	 * 2.购物车商品列表
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public List<NewCart> queryProductInCart(long userId) throws SQLException;
	/**
	 * 3.删除某件购物车商品
	 * @param pId
	 * @return
	 * @throws SQLException
	 */
	public int deleteCart(long pId) throws SQLException;
	/**
	 * 4.修改购物车商品的数量
	 * @param cart
	 * @return
	 * @throws SQLException
	 */
	public int updateCart(Cart cart) throws SQLException;
	
}
