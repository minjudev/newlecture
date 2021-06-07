package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

@Service
public class NoticeServiceImp implements NoticeService {

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

	// 구현체 얻기, 업무 로직 짜는 곳
	@Override
	public List<Notice> getList() {
		List<Notice> list = dao.getList();
		
		return list;
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
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

}
