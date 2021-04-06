/**
 * 
 */
package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MuseumDao;
import com.example.demo.model.dto.VisitorCount;
import com.example.demo.model.dto.VisitorResponse;
import com.example.demo.model.dto.VisitorsRequest;

/**
 * @author anuraggupta
 *
 */
@Service
public class MesuemServiceImpl implements MuseumService {

	@Autowired
	private MuseumDao dao;
	
	@Override
	public int getvisitors(LocalDateTime date) {

		LocalDateTime startDate = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 0, 0, 0);

		return dao.findVisitorsByDate(startDate, date);

	}

	@Override
	public VisitorResponse getvisitors(VisitorsRequest requestTo) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime fromTimeStamp = LocalDateTime.parse(requestTo.getFromTimeStamp(), formatter);
		LocalDateTime toTimeStamp = LocalDateTime.parse(requestTo.getToTimeStamp(), formatter);
		List<VisitorCount>  visitorCount = dao.findVisitorsByDateAndGranurity(fromTimeStamp, toTimeStamp,
				requestTo.getEventType(), requestTo.getGranularityType());

		int total = visitorCount.stream().collect(Collectors.summingInt(VisitorCount::getCount));
		
		return VisitorResponse.builder().total(total).visitorCount(visitorCount).build();
	
	}

	/*
	 * private List<VisitorCount> MapVisitoeCount(List<Ticket> tickets) {
	 * List<VisitorCount> visitorCounts = new ArrayList<>();
	 * tickets.stream().forEach(ticket ->{ VisitorCount count = new VisitorCount();
	 * 
	 * });
	 * 
	 * return null; }
	 */

}
