package com.chanokchon.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration เป็นการบอก Spring ว่านี่คือ class สำหรับ configuration ที่ต้องการให้ spring เข้ามา manage
@Configuration 
public class HelloWorldConfiguration {
	@Bean // ทำให้ method นี้ถูกจัดการโดย Spring Container
	public String name() {
		return "Chanokchon";
	}
}
