package com.example.personalsite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.personalsite.mapper")
public class PersonalsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalsiteApplication.class, args);
	}

}
