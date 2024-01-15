package com.wildcodeschool.webook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class WebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebookApplication.class, args);
	}

}
