package com.newlecture.web.service;

import java.util.List;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

// A 인터페이스
// A를 구현한 구현체의 이름은? Aimp 클래스
// 컨테이너에 담는 것은 구현체를 담아야 함
public interface CommentService {
	
	Notice get(int id);
	List<Notice> getList();
	List<Notice> getList(int page, String field, String query);
	
	int insert(Notice notice);
	int delete(int id);
	int hitUp(int id); // sql 모르는 사람도 이애할 수 있을 만큼 직관적인 명령어 사용하기
	int likeUp(int id);
}
