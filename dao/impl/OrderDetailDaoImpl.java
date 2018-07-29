package com.hwua.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.OrderDetailDao;
import com.hwua.entity.OrderDetail;
import com.hwua.util.C3P0Util;

public class OrderDetailDaoImpl implements OrderDetailDao{

	@Override
	public int insertOrderDetail(OrderDetail orderDetail) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "insert into hwua_order_detail(HO_ID,HP_ID,HOD_QUANTITY,HOD_COST) values(?,?,?,?)";
		Object[] params = {orderDetail.getHo_id(),orderDetail.getHp_id(),orderDetail.getHod_quantity(),orderDetail.getHod_cost()};
		return qr.update(sql, params);
	}
	
}
