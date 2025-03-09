package com.test.spring_1;

import org.springframework.stereotype.Component;

@Component
public class Bicycle implements Vehicle {
	public void drive() {
		System.out.println("pedal marna start ho gaya");
	}

}
