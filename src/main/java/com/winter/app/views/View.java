package com.winter.app.views;

import java.util.List;

import com.winter.app.regions.RegionDTO;

public class View {
	
	//Regions를 출력
	public void view(List<RegionDTO> ar) {
		for(RegionDTO regionDTO:ar) {
			System.out.println(regionDTO.getRegion_id()+" : "+regionDTO.getRegion_name());
			System.out.println("==============================");
		}
	}

}
