package com.hwua.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hwua.dao.UserDao;
import com.hwua.entity.User;
import com.hwua.util.C3P0Util;

public class UserDaoImpl implements UserDao {

	@Override
	public User queryUserForLogin(User user) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT * FROM hwua_user WHERE HU_USER_NAME=? AND HU_PASSWORD=?";
		return qr.query(sql, new BeanHandler<User>(User.class), user.getHu_user_name(), user.getHu_password());
	}

	@Override
	public int insertUser(User user) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "insert into hwua_user(HU_USER_NAME,HU_PASSWORD,HU_SEX,HU_BIRTHDAY,HU_IDENTITY_CODE,HU_EMAIL,HU_MOBILE,HU_ADDRESS,HU_STATUS) values(?,?,?,?,?,?,?,?,?)";
		Object[] params = { user.getHu_user_name(), user.getHu_password(), user.getHu_sex(),
				user.getHu_birthday(), user.getHu_identity_code(), user.getHu_email(),
				user.getHu_mobile(), user.getHu_address() ,user.getHu_status()};
		return qr.update(sql, params);
	}

	@Override
	public User queryUserByName(String name) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_user where HU_USER_NAME=?";
		return qr.query(sql, new BeanHandler<User>(User.class), name);
	}

	@Override
	public User queryUserByEmail(String email) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * from hwua_user where HU_EMAIL=?";
		return qr.query(sql, new BeanHandler<User>(User.class), email);
	}

	@Override
	public User queryUserForFindPassword(String uname, String uemail) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT * FROM hwua_user WHERE HU_USER_NAME=? AND HU_EMAIL=?";
		return qr.query(sql, new BeanHandler<User>(User.class), uname, uemail);
	}

	@Override
	public int updatePassword(String uname,String newPassword) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();		
		String sql = "UPDATE hwua_user SET HU_PASSWORD=? WHERE HU_USER_NAME=?";
		return qr.update(sql,newPassword, uname);
	}

	@Override
	public int updateUserStatus(String uname,int status) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();		
		String sql = "UPDATE hwua_user SET HU_STATUS=? WHERE HU_USER_NAME=?";
		return qr.update(sql,status, uname);
	}
}
