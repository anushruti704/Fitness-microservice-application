package com.fitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.dto.ActivityRequest;
import com.fitness.dto.ActivityResponse;
import com.fitness.service.ActivityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {
	
	private ActivityService service;

	@PostMapping
	public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request){
		return ResponseEntity.ok(service.trackActivity(request));
	}
	
	@GetMapping
	public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader("X-User-ID") String userId){
		
		return ResponseEntity.ok(service.getUserActivities(userId));
		
	}
	
	@GetMapping("/{activityId}")
	public ResponseEntity<ActivityResponse> getActivityById(@PathVariable String activityId){
		
		return ResponseEntity.ok(service.getActivityById(activityId));
		
	}
}
