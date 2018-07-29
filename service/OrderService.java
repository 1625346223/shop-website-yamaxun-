package com.hwua.service;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.NewOrder;
import com.hwua.entity.NewOrderListBody;
import com.hwua.entity.NewOrderListHead;
import com.hwua.entity.Order;
import com.hwua.entity.OrderDetail;

public interface OrderService {
	/**
	 * 1.添加
	 * @param order
	 * @return
	 */
	public int insertOrder(Order order);
	/**
	 * 2.查询所有的订单信息
	 * @param userId
	 * @return
	 */
	//public List<NewOrder> queryAllOrder(long userId);
	
	public List<NewOrderListHead> queryAllOrder1(long userId) ;
	
	public List<NewOrderListBody> queryAllOrder2(long userId) ;
	/**
	 * 3.查询订单的编号给detail
	 * @param userId
	 * @return
	 */
	public Order queryOrderId(long userId) ;
}
