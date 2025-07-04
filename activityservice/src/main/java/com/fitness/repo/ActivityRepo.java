package com.fitness.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fitness.model.Activity;

@Repository
public interface ActivityRepo extends MongoRepository<Activity, String>{

	List<Activity> findByUserId(String userId);

}
