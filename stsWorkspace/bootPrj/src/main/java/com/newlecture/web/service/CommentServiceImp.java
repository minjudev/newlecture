package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Service
public class CommentServiceImp implements NoticeService {
	// 구현체 얻기, 업무 로직 짜는 곳

	/*
	 * 1. 생성자 인젝션
	 * 2. Setter 인젝션
	 * 
	 * 3. 필드 인젝션
	 */
	
	// 필드 인젝션
	@Autowired
	private NoticeDao dao;
		
	// 생성자 인젝션
	/*
	@Autowired
	public NoticeServiceImp(NoticeDao noticeDao) {
		// 가져오자마다 다른 초기화 로직이 동작하게 할 수 있다
	}*/

	@Override
	public Notice get(int id) {
		Notice notice = dao.get(id);
		
		return notice;
	}
	
	@Override
	public List<Notice> getList() {
		List<Notice> list = dao.getList();
		
		return list;
	}
	
	@Override
	public List<Notice> getList(int page, String field, String query) { // field: 키, query: 값으로 들어갈 녀석
		List<Notice> list = dao.getList(page, field, query);

		return list;
	}

	@Override
	public int insert(Notice notice) {
		
		return dao.insert(notice);
	}

	@Override
	public int hitUp(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int likeUp(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		
		return dao.delete(id);
	}
}
