package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.NewOrder;
import com.hwua.entity.NewOrderListBody;
import com.hwua.entity.NewOrderListHead;
import com.hwua.entity.Order;

public interface OrderDao {
	/**
	 * 1.添加给订单列表
	 * @param order
	 * @return
	 * @throws SQLException
	 */
	public int insertOrder(Order order) throws SQLException ;
	/**
	 * 2.查询所有订单信息
	 * @param userId
	 * @return
	 * @throws SQLException
	 *//*
	public List<NewOrder> queryAllOrder(long userId) throws SQLException ;*/
	
	public List<NewOrderListHead> queryAllOrder1(long userId) throws SQLException ;
	
	public List<NewOrderListBody> queryAllOrder2(long userId) throws SQLException ;
	
	
	/**
	 * 3.查询最新订单的订单号
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public Order queryOrderId(long userId) throws SQLException;
}
