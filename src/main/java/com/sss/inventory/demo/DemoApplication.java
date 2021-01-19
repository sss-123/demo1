package com.sss.inventory.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sss.inventory.demo", "com.sss.inventory.demo.domain.Inventory", "com.sss.inventory.demo.dao", "com.sss.inventory.demo.service"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Demo Inventory App started");
	}

}
