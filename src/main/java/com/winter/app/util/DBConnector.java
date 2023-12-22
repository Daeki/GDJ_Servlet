package com.winter.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	//1. IP:PORT
	//2. ID, PW
	public void getConnector() {
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		//1. driver를 메모리에 로딩(객체 생성)
		try {
			Class.forName(driver);
			//2. DB연결
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3. Sql문 생성
			String sql = "SELECT REGION_NAME, REGION_ID FROM REGIONS";
			
			//4. SQL문 미리 전송
			PreparedStatement st = con.prepareStatement(sql);
			
			//5.
			
			//6. 최종 전송 및 결과 처리
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				//rs = 1, Europe
				int n = rs.getInt(1);
				String name = rs.getString(2);
				System.out.println(n+" : "+name);
				System.out.println("================");
			}
			
			
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
