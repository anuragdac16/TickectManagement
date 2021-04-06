package com.example.demo.model.dto;

import lombok.Data;

@Data
public class VisitorsRequest {

	private String fromTimeStamp;
	private String toTimeStamp;
	private Granularity granularityType;
	private String eventType;
}
