package com.dracoul.formations.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dracoul.formations.entity.Materiel;
import com.dracoul.formations.exception.UserNotFoundException;
import com.dracoul.formations.repo.MaterielRepo;

@Service
@Transactional
public class MaterielService {
private final MaterielRepo materielRepo;
	
	@Autowired
	public MaterielService(MaterielRepo materielRepo) {
		this.materielRepo = materielRepo;
	}
	
	public Materiel addMateriel(Materiel materiel) {
		materiel.setMaterielCode(UUID.randomUUID().toString());
		return materielRepo.save(materiel);
	}
	
	public List<Materiel>findAllMateriels(){
		return materielRepo.findAll();  
	}
	
	public Materiel updateMateriel(Materiel materiel) {
		return materielRepo.save(materiel);
	}
	
	public Materiel findMateriel(Long id) {
		return materielRepo.findPersonnelById(id)
				.orElseThrow(() -> new UserNotFoundException("Materiel by id "+ id + "was not found")); 
	}
	
	public Materiel findMaterielNom(String nom) {
		return materielRepo.findPersonnelByNom(nom)
				.orElseThrow(() -> new UserNotFoundException("Materiel by id "+ nom + "was not found")); 
	}
	
	public void deleteMateriel(Long id) {
		materielRepo.deletePersonnelById(id);
	}
	

}
