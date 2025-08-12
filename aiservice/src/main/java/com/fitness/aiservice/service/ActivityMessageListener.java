package com.fitness.aiservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fitness.aiservice.model.Activity;
import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.repository.RecommendationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityMessageListener {
	
	private final ActivityAIService activityAIService;
	private final RecommendationRepository recommendationRepository;
	
	@RabbitListener(queues = "activity.queue")
	public void processActivity(Activity activity) {
		log.info("ActivityMessageListener::processActivity: Received activity for processing: {}", activity.getId());
//		log.info("Generate recommendation: {}", activityAIService.generateRecommendation(activity));
		Recommendation recommendation = activityAIService.generateRecommendation(activity);
		recommendationRepository.save(recommendation);
		
	}

}
