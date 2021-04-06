package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.VisitorResponse;
import com.example.demo.model.dto.VisitorsRequest;
import com.example.demo.service.MuseumService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/museum")
@Slf4j
public class MuseumController {

	@Autowired
	private MuseumService service;

	//http://localhost:8080/v1/museum/visitors?date=2021-04-05 12:15:00
	
	@GetMapping("/visitors")
	public ResponseEntity<Integer> getVisitorsCount(@RequestParam(value = "date") String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime time = LocalDateTime.parse(date, formatter);

		
		log.debug("Time : {}", time);
		return new ResponseEntity<>(service.getvisitors(time), HttpStatus.OK);
	}

	
	//http://localhost:8080/v1/museum/visitors
	@PostMapping("/visitors")
	public ResponseEntity<VisitorResponse> getVisitors(@RequestBody VisitorsRequest requestTo) {
		
		return new ResponseEntity<>(service.getvisitors(requestTo), HttpStatus.OK);
	}
}
