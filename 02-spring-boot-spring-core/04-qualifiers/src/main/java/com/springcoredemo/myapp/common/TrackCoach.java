package com.springcoredemo.myapp.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "Track Coach: Train!";
	}

}
