package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Comment;

public interface CommentDao {
	/**
	 * 1.查询留言
	 * @return
	 * @throws SQLException
	 */
	public List<Comment> queryComment() throws SQLException ;
	/**
	 * 2.添加留言
	 * @return
	 * @throws SQLException
	 */
	public int insertComment(Comment comment) throws SQLException;
	
}
