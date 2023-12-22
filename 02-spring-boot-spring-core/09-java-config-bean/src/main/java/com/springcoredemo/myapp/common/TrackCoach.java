package com.springcoredemo.myapp.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

	public TrackCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Track Coach: Train!";
	}

}
