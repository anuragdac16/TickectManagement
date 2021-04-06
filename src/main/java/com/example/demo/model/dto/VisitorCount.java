package com.example.demo.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VisitorCount {

	private LocalDate time;
	private int count;
}
