package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Repository
public class MyBatisNoticeDao implements NoticeDao {
	
	
	// @Autowired
	private SqlSession sqlSession; // 스프링 컨테이너에 담겨져 있음, 보따리에 담겨져있으니 autowired로 사용 가능
	private NoticeDao mapper;
	
	@Autowired //  MyBatisNoticeDao가 생성될 때 바로 mapper를 가져오기 위해 생성자 DI 사용하기
	public MyBatisNoticeDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(NoticeDao.class);
	}
	
	@Override
	public Notice get(int id) {
		return mapper.get(id);
	}

	@Override
	public List<Notice> getList() {
		return getList(0, 10, "title", ""); // 빈 공백을 null로 바꿔도 됨
	}

	@Override
	public List<Notice> getList(int offset, int size) {
		return getList(offset, size, "title", "");
	}

	@Override
	public List<Notice> getList(int offset, int size, String field, String query) {
		
		return mapper.getList(offset, size, field, query);
	}
	
	@Override
	public List<Notice> getListIn(int[] ids) {

		return mapper.getListIn(ids);
	}
	
	@Override
	public List<NoticeView> getViewList(int page, String field, String query) {

		return mapper.getViewList(page, field, query);
	}

	@Override
	public int getCount(String field, String query) {

		return mapper.getCount(field, query);
	}
	
	@Override
	public int insert(Notice notice) {
		
		return mapper.insert(notice);
	}

	@Override
	public int update(Notice notice) {

		return mapper.update(notice);
	}

	@Override
	public int delete(int id) {
		
		return mapper.delete(id);
	}

}
