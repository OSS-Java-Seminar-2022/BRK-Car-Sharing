package com.brk.CarShare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CarShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarShareApplication.class, args);
	}

}
