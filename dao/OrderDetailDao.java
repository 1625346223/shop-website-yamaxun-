package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.OrderDetail;

public interface OrderDetailDao {
	/**
	 * 1.添加
	 * @param orderDetail
	 * @return
	 * @throws SQLException
	 */
	public int insertOrderDetail(OrderDetail orderDetail) throws SQLException ;

}
