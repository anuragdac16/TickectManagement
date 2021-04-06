package com.example.demo.service;

import java.time.LocalDateTime;

import com.example.demo.model.dto.VisitorResponse;
import com.example.demo.model.dto.VisitorsRequest;

public interface MuseumService {

	public int getvisitors(LocalDateTime date);

	public VisitorResponse getvisitors(VisitorsRequest requestTo);
}
