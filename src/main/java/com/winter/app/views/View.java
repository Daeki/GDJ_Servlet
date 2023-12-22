package com.winter.app.views;

import java.util.List;

import com.winter.app.regions.RegionDTO;

public class View {
	//departmentView
	
	//Regions를 출력
	public void regionView(List<RegionDTO> ar) {
		for(RegionDTO regionDTO:ar) {
			System.out.println(regionDTO.getRegion_id()+" : "+regionDTO.getRegion_name());
			System.out.println("==============================");
		}
	}

}
