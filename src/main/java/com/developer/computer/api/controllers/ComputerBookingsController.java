package com.developer.computer.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.developer.computer.api.model.AvailableSpaceResponse;
import com.developer.computer.api.model.UserResponseModel;

@RestController
@RequestMapping("/bookings")
public class ComputerBookingsController {

	
	@PostMapping()
	public ResponseEntity<UserResponseModel> getBookings() {
		String uri = "http://localhost:8080/bookings";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("https://www.maersk.com/api/bookings/checkAvailable", null, UserResponseModel.class);
		AvailableSpaceResponse availableSpaceResponse = getMockedResponse();
		UserResponseModel model = getReturnResponse(availableSpaceResponse);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);
	}

	private UserResponseModel getReturnResponse(AvailableSpaceResponse availableSpaceResponse) {
		UserResponseModel userResponseModel = new UserResponseModel();
		if(availableSpaceResponse.getAvailableSpace()==0) {
			userResponseModel.setAvailable(false);
		}else {
			userResponseModel.setAvailable(true);
		}
		return userResponseModel;
	}

	private AvailableSpaceResponse getMockedResponse() {
		AvailableSpaceResponse availableSpaceResponse = new AvailableSpaceResponse();
		availableSpaceResponse.setAvailableSpace(6);
		return availableSpaceResponse;
	}
}
