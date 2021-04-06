package com.example.demo.dao;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Ticket;

public interface MuseumDao extends JpaRepository<Ticket, Integer> , CustomMuseumDao{

	@Query("select count(*) from Ticket where entry_date >= :startDate and exit_date <= :endDate")
	public int findVisitorsByDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

	
}
