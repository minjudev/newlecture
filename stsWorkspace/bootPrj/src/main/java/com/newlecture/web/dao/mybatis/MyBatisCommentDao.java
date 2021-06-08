package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.CommentDao;
import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Comment;

@Repository
public class MyBatisCommentDao implements CommentDao {

	private SqlSession sqlSession; 
	private CommentDao mapper;
	
	public MyBatisCommentDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(CommentDao.class);
	}
	
	@Override
	public Comment get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<Comment> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public List<Comment> getList(int page) {
		// TODO Auto-generated method stub
		return mapper.getList(page);
	}

	@Override
	public List<Comment> getList(int page, String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getList(page, field, query);
	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getCount(field, query);
	}

	@Override
	public int insert(Comment Comment) {
		// TODO Auto-generated method stub
		return mapper.insert(Comment);
	}

	@Override
	public int update(Comment Comment) {
		// TODO Auto-generated method stub
		return mapper.update(Comment);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

}
