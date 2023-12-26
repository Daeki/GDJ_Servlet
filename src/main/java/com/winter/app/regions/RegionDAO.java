package com.winter.app.regions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.util.DBConnector;

public class RegionDAO {
	
	//update
	public int update(RegionDTO regionDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql="UPDATE REGIONS SET REGION_NAME=? WHERE REGION_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, regionDTO.getRegion_name());
		st.setInt(2, regionDTO.getRegion_id());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
	//Insert
	public int add(RegionDTO regionDTO)throws Exception{
		Connection con = DBConnector.getConnector();
		
		String sql = "INSERT INTO REGIONS VALUES(?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	//detail
	public RegionDTO getDetail(RegionDTO regionDTO)throws Exception{
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, regionDTO.getRegion_id());
		
		ResultSet rs = st.executeQuery();
		
		RegionDTO resultDTO=null;
		
		if(rs.next()) {
			resultDTO = new RegionDTO();
			resultDTO.setRegion_id(rs.getInt("REGION_ID"));
			resultDTO.setRegion_name(rs.getString("REGION_NAME"));
		}
		
		return resultDTO;
	}
	
	public List<RegionDTO> getList() throws Exception {
	
		//1. driver를 메모리에 로딩(객체 생성)
		
		Connection con =DBConnector.getConnector();
		//3. Sql문 생성
		String sql = "SELECT REGION_NAME, REGION_ID FROM REGIONS";
			
			//4. SQL문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
			
			//5.
			
			//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		List<RegionDTO> ar = new ArrayList<RegionDTO>();
		
		while (rs.next()) {
				//rs = 1, Europe
			RegionDTO regionDTO = new RegionDTO();
			int n = rs.getInt("REGION_ID");
			regionDTO.setRegion_id(n);
			regionDTO.setRegion_name(rs.getString("REGION_NAME"));
			
			ar.add(regionDTO);
		}

		DBConnector.disConnect(rs, st, con);
		return ar;
	}

}
