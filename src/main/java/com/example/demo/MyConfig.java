package com.example.demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.web.CompteRestJaxRSAPI;

@Configuration
public class MyConfig {
   
	//@Bean
	public ResourceConfig resourceConfig() {
		ResourceConfig jerseyServlet = new ResourceConfig();
		jerseyServlet.register(CompteRestJaxRSAPI.class);
		return jerseyServlet;
	}
}
