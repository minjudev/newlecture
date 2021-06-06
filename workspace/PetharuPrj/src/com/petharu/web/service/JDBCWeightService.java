package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.petharu.web.entity.Pet;
import com.petharu.web.entity.Weight;

public class JDBCWeightService implements WeightService {
	public List<Pet> getpetList(int memberid){
		List<Pet> list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM PET WHERE MEMBER_ID="+memberid;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //����̹� ����
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357"); //����
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				
				Pet pet = new Pet();
				pet.setId(id);
				pet.setName(name);

				list.add(pet);
			}
			
			rs.close();
			st.close();
		}catch (Exception e) {
			throw new ServiceException();
		}
		return list;
		
		
	}
	
	public List<Weight> getList(){
		List<Weight> list = new ArrayList<>();
		
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = "SELECT * FROM WEIGHT";
		String sql = "SELECT W.*,SUBSTR(MEASURE_DATETIME,0,10) DA FROM WEIGHT W ORDER BY DA";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //����̹� ����
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357"); //����
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				int petId = rs.getInt("PET_ID");
				String measureDatetime = rs.getString("MEASURE_DATETIME");
				float kg = rs.getFloat("KG");
				
				Weight weight = new Weight();
				weight.setId(id);
				weight.setPetId(petId);
				weight.setMeasureDatetime(measureDatetime);
				weight.setKg(kg);
				
				list.add(weight);
			}
			
			rs.close();
			st.close();
		}catch (Exception e) {
			throw new ServiceException();
		}
		return list;
	}
	
	public List<Weight> getList(int petid){
		List<Weight> list = new ArrayList<>();
		
		System.out.println("������̵�"+petid);
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT W.*,SUBSTR(MEASURE_DATETIME,0,10) DA FROM WEIGHT W WHERE PET_ID="+petid+" ORDER BY DA";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //����̹� ����
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357"); //����
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				int petId = rs.getInt("PET_ID");
				String measureDatetime = rs.getString("MEASURE_DATETIME");
				float kg = rs.getFloat("KG");
				String petname = rs.getString("PET_NAME");
				
				Weight weight = new Weight();
				weight.setId(id);
				weight.setPetId(petId);
				weight.setMeasureDatetime(measureDatetime);
				weight.setKg(kg);
				weight.setPetname(petname);
				
				list.add(weight);
			}
			
			rs.close();
			st.close();
		}catch (Exception e) {
			throw new ServiceException();
		}
		return list;
	}
	
	public int insert(Weight weight) {
		int result = 0;
		
		String sql = "INSERT INTO WEIGHT(PET_ID,MEASURE_DATETIME,KG,PET_NAME) VALUES(?,?,?,?)"; //?�� ������ �ȾƳ�������
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU","1357"); //����̹� �ε�
			
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(weight.getMeasureDatetime());
			st.setInt(1,weight.getPetId()); //�����͸� ����
			st.setString(2,weight.getMeasureDatetime());
			st.setFloat(3, weight.getKg());
			st.setString(4, weight.getPetname());
			
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
		
		} catch (Exception e) {
			throw new ServiceException();
		}
		return result;
		
	}
	
	public Weight get(int id) {
		Weight weight = null;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM WEIGHT WHERE ID="+id;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU","1357"); //����̹� �ε�
			Statement st = con.createStatement(); //�������
			ResultSet rs = st.executeQuery(sql); //�������
			
			
			if(rs.next()) {
				int petId = rs.getInt("PET_ID");
				String measureDatetime = rs.getString("MEASURE_DATETIME");
				float kg = rs.getFloat("KG");
				
				weight = new Weight();
				weight.setId(id);
				weight.setPetId(petId);
				weight.setMeasureDatetime(measureDatetime);
				weight.setKg(kg);
			}
			
			
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		
		return weight;
	}

	public int update(Weight weight) {
		int result = 0;
		
		String sql = "UPDATE WEIGHT SET MEASURE_DATETIME=?,KG=? WHERE ID=?";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU","1357"); //����̹� �ε�
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,weight.getMeasureDatetime()); //�����͸� ����
			st.setFloat(2,weight.getKg());
			st.setInt(3,weight.getId());
			
			
			//executeQuery(): Select
			//executeUpdate(): Update/Delete/Insert
			result = st.executeUpdate(); 
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
		
	}

	@Override
	public int delete(int id) {
		int result = 0;
		
		String sql = "DELETE FROM WEIGHT WHERE ID=?";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU","1357"); //����̹� �ε�
		
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			result = st.executeUpdate(); 
			
			st.close();
			con.close();
		
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
	}
	
	
	
}

