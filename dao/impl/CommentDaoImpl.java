package com.hwua.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.CommentDao;
import com.hwua.entity.Comment;
import com.hwua.util.C3P0Util;

public class CommentDaoImpl implements CommentDao{

	@Override
	public List<Comment> queryComment() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "select * FROM hwua_comment";
		return qr.query(sql, new BeanListHandler<Comment>(Comment.class));
	}

	@Override
	public int insertComment(Comment comment) throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "insert into hwua_comment(HC_CONTENT,HC_CREATE_TIME,HC_NICK_NAME,HC_STATE) values(?,?,?,?)";
		Object[] params = { comment.getHc_content(), comment.getHc_create_time(),
				comment.getHc_nick_name(),comment.getHc_state()};
		return qr.update(sql, params);
	}

}
