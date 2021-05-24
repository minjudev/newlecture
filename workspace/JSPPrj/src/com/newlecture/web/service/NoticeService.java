package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;

public interface NoticeService {
	
	List<Notice> getList() throws ClassNotFoundException, SQLException;
	List<Notice> getList(int page, String field, String query) throws SQLException, ClassNotFoundException;
		
	Notice get(int id) throws ClassNotFoundException, SQLException;
	int getCount(String field, String query) throws SQLException, ClassNotFoundException;	
	int update(Notice notice) throws ClassNotFoundException, SQLException;
	int insert(Notice notice) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
		
}
