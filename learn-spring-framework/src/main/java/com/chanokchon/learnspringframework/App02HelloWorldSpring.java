package com.chanokchon.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// 1: Launch a spring context
		/*
		 * 
		 * AnnotationConfigApplicationContext
		 * เป็นคลาสที่ใช้ในการจัดการกับ Container ของ Spring โดยใช้การกำหนดค่าผ่าน Annotations 
		 * โดยด้านใน container จะคอยจัดการกับ object ต่าง ๆ ที่ถูกกำหนดเป็น Spring beans
		 * 
		 */
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

		// 2: ระบุ @Configuration ที่ต้องการให้ Spring จัดการ ในตัวอย่างคือ HelloWorldConfig
		
		// 3: ดึงข้อมูลที่จัดการโดย spring
		System.out.println(context.getBean("name"));; // อะไรก็ตามที่ถูกจัดการโดย Spring bean เราสามารถระบุชื่อเพื่อเข้าถึงได้
		
	}

}
