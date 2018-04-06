package com.kkd.temp;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TempServiceController {
	
	
	ArrayList<FarmerData> fd = new ArrayList<FarmerData>();
	@PostMapping("/farmer/register")
	public String addFarmer(@RequestBody FarmerData farmer ) {
		
		fd.add(farmer);
		if(fd.size()==1)
			fd.get(0).setKkd_id("kkd_farm_1000");
		return "Added Successfully";
	}
	@GetMapping("/lastUserId")
	public String getLastUserId() {
		//this is just to mock the data. Not the actual logic.
		return fd.get(fd.size()-2).getKkd_id();
	}
	@PostMapping("/savekkdid")
	public void saveKkdId(@RequestBody String new_kkd_id) {
		//this is just to mock the data. Not the actual logic.
			fd.get(fd.size()-1).setKkd_id(new_kkd_id);
		
	}
	@GetMapping("/getAll")
	public ArrayList<FarmerData> getAll(){
		//this is just to mock the data. Not the actual logic.
		return fd;
	}

}
