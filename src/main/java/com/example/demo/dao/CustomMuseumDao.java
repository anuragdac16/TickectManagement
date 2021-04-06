package com.example.demo.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.model.dto.Granularity;
import com.example.demo.model.dto.VisitorCount;

public interface CustomMuseumDao {

	public List<VisitorCount> findVisitorsByDateAndGranurity(LocalDateTime fromTimeStamp,
			LocalDateTime toTimeStamp, String eventType, Granularity granularity);

}
