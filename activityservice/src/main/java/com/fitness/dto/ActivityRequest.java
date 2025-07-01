package com.fitness.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.fitness.model.ActivityType;

import lombok.Data;

@Data
public class ActivityRequest {
	
	private String userId;
	 private ActivityType type;
	 private Integer duration;
	 private Integer caloriesBurned;
	 private LocalDateTime startTime;
	 private Map<String, Object> additionalMetrics;

}
