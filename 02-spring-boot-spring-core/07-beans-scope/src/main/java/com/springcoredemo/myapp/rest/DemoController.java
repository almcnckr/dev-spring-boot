package com.springcoredemo.myapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcoredemo.myapp.common.Coach;

@RestController
public class DemoController {

	// define a private field for the dependency
	private Coach coach;
	private Coach anotherCoach;

	@Autowired
	public DemoController(
			@Qualifier("cricketCoach") Coach coach,
			@Qualifier("cricketCoach") Coach anotherCoach) {
		System.out.println("In constructor: " + getClass().getSimpleName());
		this.coach = coach;
		this.anotherCoach = anotherCoach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return this.coach.getDailyWorkout();
	}

	@GetMapping("/check")
	public String check() {
		return "Comparing beans: coach == anotherCoach, " + (coach == anotherCoach);
	}
}
