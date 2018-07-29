package com.hwua.service;

import java.util.List;

import com.hwua.entity.Comment;

public interface CommentService {
	/**
	 * 1.查询留言
	 * @return
	 */
	public List<Comment> queryComment() ;
	/**
	 * 2.添加留言
	 * @param comment
	 * @return
	 */
	public int insertComment(Comment comment);
}
