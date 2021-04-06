/**
 * 
 */
package com.example.demo.model.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * @author anuraggupta
 *
 */
@Data
@Builder
public class VisitorResponse {

	private int total;
	private List<VisitorCount> visitorCount;
}
