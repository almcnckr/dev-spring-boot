package com.springcoredemo.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springcoredemo.myapp.common.Coach;
import com.springcoredemo.myapp.common.SwimCoach;

@Configuration
public class SportsConfig {

	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
