package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

// SQL을 대신하는 녀석(select, insert, update, delete만이 dao에 있다)
// select 반환, 필터링, 정렬, 집계 등
// 기본 단위: 레코드 단위(컬럼 단위로 업무 처리하는 것은 dao에서 생각할 일이 아님)
// SQL을 자바 객체로 바꾼 것이라고 생각하자
// 인터페이스를 구현하는 클래스를 mybatis가 저절로 만들어줌
// 스프링이 가져다 쓸 수 있도록 클래스를 콩자루에 담아줌
// 구현체
// 인터페이스는 특정 기술에 종속되서는 안된다
// 하지만 아래처럼 구현하면 인터페이스가 mybatis에 종속되는 문제 발생, dao에 쿼리를 붙이는 것은 맞지 않다
// mapper를 xml로 빼는 방법 사용
public interface NoticeDao {
	
	Notice get(int id);
	
	// 오버로드 함수는 한 번에 동시 호출 불가능(mybatis 지원X - 오버로드 구현X)
	// 오버로드 함수도 정상 작동되게 하려면 구현체를 직접 구현해야 함
	// @Select("select * from Notice")
	List<Notice> getList(); // 필터링, 정렬, 페이징, 집계
	List<Notice> getList(int page);
	List<Notice> getList(int page, String field, String query);
	List<NoticeView> getViewList(int page, String field, String query);
	
	int getCount(String field, String query);
	
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
	// int hitUp(); // SQL에는 hitUp이라는 명령어가 없음, hitUp은 서비스임
	// int likeUpt(int id); // 업무적인 명령어가 여기 들어오면 안됨, likeUp은 sql update 명령어로 처리 가능!


}
