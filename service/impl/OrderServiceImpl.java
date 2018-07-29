package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.impl.OrderDaoImpl;
import com.hwua.entity.NewOrder;
import com.hwua.entity.NewOrderListBody;
import com.hwua.entity.NewOrderListHead;
import com.hwua.entity.Order;
import com.hwua.service.OrderService;

public class OrderServiceImpl implements OrderService{

	@Override
	public int insertOrder(Order order) {
		OrderDaoImpl odi = new OrderDaoImpl();
		int rows = 0;
		try {
			rows = odi.insertOrder(order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	/*@Override
	public List<NewOrder> queryAllOrder(long userId) {
		OrderDaoImpl odi = new OrderDaoImpl();
		List<NewOrder> list = null;
		try {
			list = odi.queryAllOrder(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}*/


	@Override
	public Order queryOrderId(long userId) {
		OrderDaoImpl odi = new OrderDaoImpl();
		Order order = null;
		try {
			order = odi.queryOrderId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<NewOrderListHead> queryAllOrder1(long userId) {
		OrderDaoImpl odi = new OrderDaoImpl();
		List<NewOrderListHead> list = null;
		try {
			list = odi.queryAllOrder1(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<NewOrderListBody> queryAllOrder2(long userId) {
		OrderDaoImpl odi = new OrderDaoImpl();
		List<NewOrderListBody> list = null;
		try {
			list = odi.queryAllOrder2(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}



	

}
