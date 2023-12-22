package com.springcoredemo.myapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcoredemo.myapp.common.Coach;

@RestController
public class DemoController {

	// define a private field for the dependency
	private Coach coach;

	// define a setter for dependency injection
	
	@Autowired
	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return this.coach.getDailyWorkout();
	}

}
