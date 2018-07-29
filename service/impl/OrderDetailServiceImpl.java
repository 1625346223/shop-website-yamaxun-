package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.impl.OrderDaoImpl;
import com.hwua.dao.impl.OrderDetailDaoImpl;
import com.hwua.entity.Order;
import com.hwua.entity.OrderDetail;
import com.hwua.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService{

	@Override
	public int insertOrderDetail(OrderDetail orderDetail) {
		OrderDetailDaoImpl oddi = new OrderDetailDaoImpl();
		int rows = 0;
		try {
			rows = oddi.insertOrderDetail(orderDetail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
}
