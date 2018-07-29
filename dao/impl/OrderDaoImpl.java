package com.hwua.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.OrderDao;
import com.hwua.entity.NewOrder;
import com.hwua.entity.NewOrderListBody;
import com.hwua.entity.NewOrderListHead;
import com.hwua.entity.Order;
import com.hwua.entity.Product;
import com.hwua.util.C3P0Util;

public class OrderDaoImpl implements OrderDao{

	@Override
	public int insertOrder(Order order) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "insert into hwua_order(HO_USER_ID,HO_USER_NAME,HO_USER_ADDRESS,HO_CREATE_TIME,HO_COST,HO_STATUS,HO_TYPE) values(?,?,?,?,?,?,?)";
		Object[] params = {order.getHo_user_id(),order.getHo_user_name(),order.getHo_user_address(),order.getHo_create_time(),order.getHo_cost(),order.getHo_status(),order.getHo_type() };
		return qr.update(sql, params);
	}
	@Override
	public Order queryOrderId(long userId) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select max(ho_id) ho_id,ho_user_id,ho_user_name,ho_user_address,ho_create_time,ho_cost,ho_status,ho_type from hwua_order where ho_user_id=?";
		return qr.query(sql, new BeanHandler<Order>(Order.class), userId);
	}
	
	@Override
	public List<NewOrderListHead> queryAllOrder1(long userId) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select ho_create_time,ho_id,ho_cost from hwua_order where ho_user_id=? ORDER BY ho_id DESC ";
		return qr.query(sql, new BeanListHandler<NewOrderListHead>(NewOrderListHead.class), userId);
	}
	@Override
	public List<NewOrderListBody> queryAllOrder2(long userId) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select p.hp_id,p.hp_file_name,p.hp_name,p.hp_price,od.hod_quantity,o.ho_id from hwua_order o,hwua_order_detail od,hwua_product p where p.hp_id=od.hp_id and o.ho_id=od.ho_id and o.ho_user_id=? ORDER BY o.ho_id DESC ";
		return qr.query(sql, new BeanListHandler<NewOrderListBody>(NewOrderListBody.class), userId);
	}
	

}
