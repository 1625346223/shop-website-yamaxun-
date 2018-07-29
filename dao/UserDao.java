package com.hwua.dao;

import java.sql.SQLException;

import com.hwua.entity.User;

public interface UserDao {
	/**
	 * 1.登录验证
	 * 
	 * @param user
	 * @return
	 */
	public User queryUserForLogin(User user) throws SQLException;

	/**
	 * 2.添加用户
	 * 
	 * @param name
	 * @return
	 */
	public abstract int insertUser(User user) throws SQLException;

	/**
	 * 3.通过名字查询指定的用户ajax
	 * 
	 * @param name
	 * @return
	 */
	public User queryUserByName(String name) throws SQLException;
	/**
	 * 4.通过邮箱查询指定的用户ajax
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public User queryUserByEmail(String email) throws SQLException;
	
	
	/**
	 * 5.1.找回密码
	 * @param uname 用户名
	 * @param uemail 邮箱
	 * @return 
	 * @throws SQLException
	 */
	public User queryUserForFindPassword(String uname,String uemail) throws SQLException;
	
	/**
	 * 5.2.设置密码
	 * @param uname 用户名
	 * @param password 新密码
	 * @return 
	 * @throws SQLException
	 */
	public int updatePassword(String uname,String password) throws SQLException;
	/**
	 * 6.修改用户登录状态
	 * @param status 1登录 0未登录
	 * @return
	 * @throws SQLException
	 */
	public int updateUserStatus(String uname,int status) throws SQLException ;
}
