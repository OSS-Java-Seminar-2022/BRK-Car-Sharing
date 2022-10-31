package com.brk.CarShare;

import com.brk.CarShare.Repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories
public class CarShareApplication implements CommandLineRunner {
	@Autowired
	IRoleRepository IRoleRepository;
	public static void main(String[] args) {
		SpringApplication.run(CarShareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
