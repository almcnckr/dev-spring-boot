package com.springcoredemo.myapp.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Baseball Coach: Train!";
	}

}
