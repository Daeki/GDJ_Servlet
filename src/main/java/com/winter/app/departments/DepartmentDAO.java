package com.winter.app.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.winter.app.util.DBConnector;

public class DepartmentDAO {
	
	public void getList() throws Exception {
		//DB접속 후 부서테이블의모든 정보를 출력
		Connection con = DBConnector.getConnector();
		
		String sql ="SELECT * FROM DEPARTMENTS";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("DEPARTMENT_ID");
			int lId = rs.getInt("LOCATION_ID");
			String name=rs.getString("DEPARTMENT_NAME");
			int mId = rs.getInt("MANAGER_ID");
			
			System.out.println(id+" : "+name+" : "+mId+" : "+lId);
			System.out.println("============================");
		}
		
		DBConnector.disConnect(rs, st, con);
		
	}

}
