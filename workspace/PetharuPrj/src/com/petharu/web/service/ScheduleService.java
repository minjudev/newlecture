package com.petharu.web.service;

import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Schedule;

public interface ScheduleService {
	List<Schedule> getList();
	List<Schedule> getList(int month, int memberId);
	
	//������ �Ѱ� ���� ���ִ� ����(�����پ��̵��)
	Schedule get(int scheduleId);
	
	//insert
	int insert(Schedule schedule) throws SQLException, ClassNotFoundException;

	int update(Schedule schedule);
	
	int delete(int scheduleId);
	
}
