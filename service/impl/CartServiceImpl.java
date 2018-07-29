package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.impl.CartDaoImpl;
import com.hwua.entity.Cart;
import com.hwua.entity.NewCart;
import com.hwua.service.CartService;

public class CartServiceImpl implements CartService{

	@Override
	public int insertCart(Cart cart) {
		CartDaoImpl cdi = new CartDaoImpl();
		int ic = 0;
		try {
			Cart cart2 = cdi.queryCart(cart);
			if (cart2==null) {
				ic = cdi.insertCart(cart);
			}else {
				int num1 = cart.getQuantity();
				int num2 = cart.getQuantity();
				Cart cart3 = new Cart(cart.getPid(), num1+num2, cart.getUserid());
				ic = cdi.updateCart(cart3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ic;
	}
	
	@Override
	public List<NewCart> queryProductInCart(long userId) {
		CartDaoImpl cdi = new CartDaoImpl();
		List<NewCart> list = null;
		try {
			list = cdi.queryProductInCart(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteCart(long pId) {
		CartDaoImpl cdi = new CartDaoImpl();
		int dc = 0;
		try {
			dc = cdi.deleteCart(pId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dc;
	}

	@Override
	public int updateCart(Cart cart) {
		CartDaoImpl cdi = new CartDaoImpl();
		int dc = 0;
		try {
			dc = cdi.updateCart(cart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dc;
	}

}
