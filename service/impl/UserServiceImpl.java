package com.hwua.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.hwua.dao.impl.UserDaoImpl;
import com.hwua.entity.User;
import com.hwua.service.UserService;
import com.hwua.util.JDBCUtils;

public class UserServiceImpl implements UserService {

	@Override
	public User queryUserForLogin(User user) {
		UserDaoImpl udi = new UserDaoImpl();
		User qufl = null;
		try {
			qufl = udi.queryUserForLogin(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qufl;
	}

	@Override
	public boolean insertUser(User user) {
		UserDaoImpl udi = new UserDaoImpl();
		int rows = 0;
		try {
			rows = udi.insertUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean queryUserByName(String name) {
		UserDaoImpl udi = new UserDaoImpl();
		User user = null;
		try {
			user = udi.queryUserByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean queryUserByEmail(String email) {
		UserDaoImpl udi = new UserDaoImpl();
		User user = null;
		try {
			user = udi.queryUserByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user == null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public User queryUserByNameAndEmail(String uname, String email) {
		UserDaoImpl udi = new UserDaoImpl();
		User user = null;
		try {
			user = udi.queryUserForFindPassword(uname, email);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public int updatePassword(String uname, String newPassword) {
		UserDaoImpl udi = new UserDaoImpl();
		int rows = 0;
		try {
			rows = udi.updatePassword(uname, newPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	/**
	 * 事务控制
	 */
	@Override
	public boolean updatePassword(String uname, String uemail, String newPassword) {
		Connection connection = null;
		//UserDaoImpl udi = new UserDaoImpl();
		try {
			connection = JDBCUtils.getConnection();
			//开始事务
			JDBCUtils.beginStraction();
			
			
			
			//提交事务
			JDBCUtils.commitStraction();
		} catch (SQLException e) {
			try {
				JDBCUtils.rollbackStraction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				JDBCUtils.release(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return false;
	}

	@Override
	public int updateUserStatus(String uname, int status) {
		UserDaoImpl udi = new UserDaoImpl();
		int rows = 0;
		try {
			rows=udi.updateUserStatus(uname, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	

}
