package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

@AutoConfigureTestDatabase(replace = Replace.NONE) 
@SpringBootTest
class MyBatisNoticeDaoTest {
	
	@Autowired
	private NoticeDao dao;

	@Test
	void test() {
		
		List<Notice> list = dao.getListIn(new int[] {23, 40, 45});
		
		// assertEquals(7, add(3, 4)); // 같은 값이면 성공이 나옴
	}
}
