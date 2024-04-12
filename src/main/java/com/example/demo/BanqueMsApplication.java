package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Compte;
import com.example.demo.entities.TypeCompte;
import com.example.demo.repositories.CompteRepositories;

@SpringBootApplication
public class BanqueMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueMsApplication.class, args);
	}
    
	@Bean
	CommandLineRunner start(CompteRepositories cpteRepo) {
		return args->{
			cpteRepo.save(new Compte(null,Math.random()*9000, new Date(), TypeCompte.EPARGNE));
			cpteRepo.save(new Compte(null,Math.random()*9000, new Date(), TypeCompte.COURANT));
			cpteRepo.save(new Compte(null,Math.random()*9000, new Date(), TypeCompte.COURANT));
			cpteRepo.findAll().forEach(c->{
				System.out.println(c.toString());
			});
		};
	}
}
