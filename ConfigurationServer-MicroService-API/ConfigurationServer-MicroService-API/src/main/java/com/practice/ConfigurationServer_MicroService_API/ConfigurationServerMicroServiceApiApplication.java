package com.practice.ConfigurationServer_MicroService_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigurationServerMicroServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServerMicroServiceApiApplication.class, args);
	}

}
