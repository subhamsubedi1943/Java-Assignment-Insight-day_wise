package com.test.spring_1;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {
	public void drive() {
		
		System.out.println("Engine start ho gaya");
		
		}
}
