package com.winter.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.winter.app.util.DBConnector;

public class EmployeeDAO {
	
	//하나 조회
	public EmployeeDTO getDetail(EmployeeDTO employeeDTO)throws Exception{
		
		Connection con = DBConnector.getConnector();
		
		String sql ="SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, employeeDTO.getEmployee_id());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
		}else {
			employeeDTO=null;
		}
		
		DBConnector.disConnect(rs, st, con);
		return employeeDTO;
	}
	
	
	//전체 조회
	public List<EmployeeDTO> getList() throws Exception {
		//배열, List, Set, Map
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		//1. 정보 선언 2. DB 연결
		Connection con = DBConnector.getConnector();
		
		//3. SQL(Query)문 생성
		String sql ="SELECT * FROM EMPLOYEES";
		
		//4. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//5. ? 값 세팅
		
		//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			
			ar.add(employeeDTO);
			
		}
		
		//7. 연결 해제
		DBConnector.disConnect(rs, st, con);
		
		return ar;
		
	}

}
