package com.dracoul.formations.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dracoul.formations.entity.Personnel;
import com.dracoul.formations.exception.UserNotFoundException;
import com.dracoul.formations.repo.PersonnelRepo;
@Service
@Transactional
public class PersonnelService {

	private final PersonnelRepo personnelRepo ;
	
	@Autowired
	public PersonnelService(PersonnelRepo personnelRepo) {
		this.personnelRepo = personnelRepo;	
	}
	
	public Personnel addPersonnel(Personnel personnel) {
		personnel.setPersonnelCode(UUID.randomUUID().toString());
		return personnelRepo.save(personnel);
	}
	
	public List<Personnel>findAllPersonnels(){
		return personnelRepo.findAll(); 
	}
	
	public Personnel updatePersonnel(Personnel personnel) {
		return personnelRepo.save(personnel);
	}
	
	public Personnel findPersonnelById(Long id) {
		return personnelRepo.findPersonnelById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id "+ id + "was not found")); 
	}
	
	public void deletePersonnel(Long id) {
		personnelRepo.deletePersonnelById(id);
	}
	
	public Personnel getUserByEmailPassord(String email, String password) {
		
		Personnel personnel = personnelRepo.findByEmailAndPassword(email, password);
		return personnel;
	}
	
	public String getTypeUserByEmailAndPassword(String email,String password) {
		Personnel personnel = getUserByEmailPassord(email,password);
		System.out.println(personnel);
		if(personnel.getType().equalsIgnoreCase("Patient"))
			return "{\"message\":\"Patient\"}";
		else if(personnel.getType().equalsIgnoreCase("Administrateur"))
			return "{\"message\":\"Administrateur\"}";
		else if(personnel.getType().equalsIgnoreCase("Laborantin"))
			return "{\"message\":\"Laborantin\"}";
		else if(personnel.getType().equalsIgnoreCase("Cardiologue"))
			return "{\"message\":\"Cardiologue\"}";
		else if(personnel.getType().equalsIgnoreCase("Pediatre"))
			return "{\"message\":\"Pediatre\"}";
		else if(personnel.getType().equalsIgnoreCase("Generaliste"))
			return "{\"message\":\"Generaliste\"}";
		else if(personnel.getType().equalsIgnoreCase("Ophtalmologue"))
			return "{\"message\":\"Ophtalmologue\"}";
		else if(personnel.getType().equalsIgnoreCase("Geniquologue"))
			return "{\"message\":\"Geniquologue\"}";
		else if(personnel.getType().equalsIgnoreCase("Dentiste"))
			return "{\"message\":\"Dentiste\"}";
		
		else
			return "null";
}
	
}
