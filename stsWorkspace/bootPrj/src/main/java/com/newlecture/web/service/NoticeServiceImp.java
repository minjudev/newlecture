package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Service
public class NoticeServiceImp implements NoticeService {
	// 구현체 얻기, 업무 로직 짜는 곳

	/*
	 * 1. 생성자 인젝션
	 * 2. Setter 인젝션
	 * 3. 필드 인젝션
	 */
	
	// 필드 인젝션
	@Autowired
	private MyBatisNoticeDao dao;
	
	// private CommentDao commentDao;
		
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
		
		List<Notice> list = getList(1, null, null);
		return list;
	}
	
	@Override
	public List<Notice> getList(int page) {
		
		List<Notice> list = getList(page, null, null);
		return list;
	}
	
	@Override
	public List<Notice> getList(int page, String field, String query) { // 여기서 1페이지에 해당하는 시작 번호, 끝 번호를 지정해서 dao에게 넘겨줘야 함
		
		int offset = (page-1)*10; // 1페이지 -> offset: 0, 2 -> 10, 3 -> 20 
		int size = 10; // size의 개수를 정하는 것은 서비스에서 해야할 일
		
		// List<Notice> list = dao.getList(page, field, query);
		List<Notice> list = dao.getList(offset, size, field, query);
		return list;
		
		/*
		for(Notice n : list) {
			n.setComments(commentDao.getListByNoticeId(n.getId()));
		}
		*/
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
	public int likeToggle(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}

	@Transactional
	@Override
	public int update(Notice notice) {

		// 완전하게 실행됐으면 hit가 0이어야 함
		notice.setHit(100);
		dao.update(notice);
		
		// "minju"라는 작성자가 없어서 오류 발생
		// 오류 발생하면 처음으로 복구 -> 원자성
		notice.setWriterId("sdfsdfs"); 
		notice.setHit(0);
		dao.update(notice);

		return 0;
	}

}
