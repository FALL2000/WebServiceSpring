package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entities.Compte;
import com.example.demo.repositories.CompteRepositories;

@RestController
@RequestMapping("/banque")
public class CompteRestController {
 
	@Autowired
	private CompteRepositories cpteRepo;
	
	@GetMapping(path = "/comptes", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Compte> compteList(){
		return cpteRepo.findAll();
	}
	
	@GetMapping("/comptes/{id}")
	public Compte getOne(@PathVariable Long id){
		return cpteRepo.findById(id).get();
	}
	
	@PostMapping("/comptes")
	public Compte save(@RequestBody Compte cpte){
		return cpteRepo.save(cpte);
	}
	
	@PutMapping("/comptes/{id}")
	public Compte update(@RequestBody Compte cpte, @PathVariable Long id){
		cpte.setId(id);
		return cpteRepo.save(cpte);
	}
	
	@DeleteMapping("/comptes/{id}")
	public void delete(@PathVariable Long id){
		 cpteRepo.deleteById(id);
	}
}
