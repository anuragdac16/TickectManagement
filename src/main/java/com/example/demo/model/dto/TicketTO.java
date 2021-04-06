/**
 * 
 */
package com.example.demo.model.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

/**
 * @author anuraggupta
 *
 */
@Data
@Builder
public class TicketTO {

	private int ticketId;
	private String eventType;
	private LocalDateTime timeStamp;
}
