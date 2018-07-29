package com.hwua.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.CartDao;
import com.hwua.entity.Cart;
import com.hwua.entity.NewCart;
import com.hwua.util.C3P0Util;

public class CartDaoImpl implements CartDao{

	@Override
	public int insertCart(Cart cart) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "insert into hwua_cart(PID,QUANTITY,USERID) values(?,?,?)";
		Object[] params = { cart.getPid(),cart.getQuantity(),cart.getUserid()};
		return qr.update(sql, params);
	}

	@Override
	public List<NewCart> queryProductInCart(long userId) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select p.hp_id,p.hp_name,p.hp_stock,p.hp_file_name,p.hp_price,SUM(c.QUANTITY) QUANTITY FROM hwua_cart c, hwua_product p WHERE c.pid=p.hp_id and c.USERID=? GROUP BY p.hp_id,p.hp_name,p.hp_stock,p.hp_file_name,p.hp_price";
		return qr.query(sql, new BeanListHandler<NewCart>(NewCart.class), userId);
	}

	@Override
	public int deleteCart(long pId) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "DELETE FROM hwua_cart WHERE PID=?";
		return qr.update(sql, pId);
	}

	@Override
	public Cart queryCart(Cart cart) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * FROM hwua_cart WHERE pid=? and USERID=?";
		Object[] params = { cart.getPid(),cart.getUserid()};
		return qr.query(sql, new BeanHandler<Cart>(Cart.class), params);
	}

	@Override
	public int updateCart(Cart cart) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "update hwua_cart set quantity=? WHERE pid=? and USERID=?";
		Object[] params = { cart.getQuantity(),cart.getPid(),cart.getUserid()};
		return qr.update(sql,params);
	}

}
