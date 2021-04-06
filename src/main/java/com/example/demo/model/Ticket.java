package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Ticket {

	@Id
	@GeneratedValue
	private int ticketId;
	private String eventType;
	private LocalDateTime timeStamp;

}
