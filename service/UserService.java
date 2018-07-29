package com.hwua.service;

import com.hwua.entity.User;

public interface UserService {
	/**
	 * 1.登录验证
	 * 
	 * @param user
	 * @return
	 */
	public User queryUserForLogin(User user);
	/**
	 * 2.添加用户
	 * 
	 * @param name
	 * @return
	 */
	public boolean insertUser(User user);
	/**
	 * 3.通过名字查询指定的用户ajax
	 * 
	 * @param name 名字
	 * @return true 可以用  false 不可以用
	 */
	public boolean queryUserByName(String name);
	/**
	 * 4.通过邮箱查询指定的用户ajax
	 * @param email 地址
	 * @return  true 可以用  false 不可以用
	 */
	public boolean queryUserByEmail(String email);
	/**
	 * 5.找回密码（根据用户名和email来定位用户）
	 * @param uname
	 * @param email
	 * @return
	 */
	public User queryUserByNameAndEmail(String uname,String email);
	
	public int updatePassword(String uname,String newPassword);
	/**
	 * 未开发的功能	
	 * @param uname
	 * @param uemail
	 * @param newPassword
	 * @return
	 */
	public boolean updatePassword(String uname,String uemail,String newPassword);
	/**
	 * 6.修改用户的状态
	 * @param uname
	 * @param status
	 * @return
	 */
	public int updateUserStatus(String uname,int status);
}
