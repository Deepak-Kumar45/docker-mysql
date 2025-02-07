package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerMysqlApplication {
	public static void main(String[] args) {
		SpringApplication.run(DockerMysqlApplication.class, args);
		System.err.println("\n\t!!..Application has been started..!!");
	}

}
