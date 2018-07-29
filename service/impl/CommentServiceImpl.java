package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.impl.CommentDaoImpl;
import com.hwua.entity.Comment;
import com.hwua.service.CommentService;

public class CommentServiceImpl implements CommentService{

	@Override
	public List<Comment> queryComment() {
		CommentDaoImpl cdi = new CommentDaoImpl();
		List<Comment> queryComment = null;
		try {
			queryComment = cdi.queryComment();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return queryComment;
	}

	@Override
	public int insertComment(Comment comment) {
		CommentDaoImpl cdi = new CommentDaoImpl();
		int ic=0;
		try {
			ic = cdi.insertComment(comment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ic;
	}

}
