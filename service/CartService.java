package com.hwua.service;

import java.util.List;

import com.hwua.entity.Cart;
import com.hwua.entity.NewCart;

public interface CartService {
	/**
	 * 1.加入购物车(如果有就修改，没有就新建)
	 * @param cart
	 * @return
	 */
	public int insertCart(Cart cart) ;
	/**
	 * 2.购物车商品列表
	 * @param userId
	 * @return
	 */
	public List<NewCart> queryProductInCart(long userId); 
	/**
	 * 3.删除商品
	 * @param pId
	 * @return
	 */
	public int deleteCart(long pId);
	/**
	 * 4.购物车里直接修改商品数量
	 * @param cart
	 * @return
	 */
	public int updateCart(Cart cart) ;
}
