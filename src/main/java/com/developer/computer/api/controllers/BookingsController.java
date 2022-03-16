package com.developer.computer.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.developer.computer.api.model.ContainerModel;
import com.developer.computer.api.model.UserResponseModel;


@RestController
@RequestMapping("/api/bookings")
public class BookingsController {

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponseModel> getAvailableBookings(@RequestBody ContainerModel containerModel) {
		String uri = "http://localhost:8080/bookings";
		RestTemplate restTemplate = new RestTemplate();
		UserResponseModel returnUserModel = restTemplate.getForObject(uri, UserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnUserModel);
	}
}
