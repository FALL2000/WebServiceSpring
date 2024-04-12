package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Compte;

public interface CompteRepositories extends JpaRepository<Compte, Long>{
   
}
