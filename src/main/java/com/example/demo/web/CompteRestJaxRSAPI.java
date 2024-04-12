package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Compte;
import com.example.demo.repositories.CompteRepositories;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
	
	@Autowired
	private CompteRepositories cpteRepo;
	
	@Path("/comptes")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Compte> compteList(){
		return cpteRepo.findAll();
	}
	
	@Path("/comptes/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Compte getOne(@PathParam(value = "id") Long id){
		return cpteRepo.findById(id).get();
	}
	
	@Path("/comptes")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Compte save(Compte cpte){
		return cpteRepo.save(cpte);
	}
	
	@Path("/comptes/{id}")
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	public Compte update(Compte cpte, @PathParam(value = "id") Long id){
		cpte.setId(id);
		return cpteRepo.save(cpte);
	}
	
	@Path("/comptes/{id}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	public void delete(@PathParam(value = "id") Long id){
		 cpteRepo.deleteById(id);
	}
	

}
