package com.dracoul.formations;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dracoul.formations.entity.Materiel;
import com.dracoul.formations.service.MaterielService;

@RestController
@RequestMapping("/materiel")
public class MaterielResource {

private final MaterielService materielService;
	
	public MaterielResource(MaterielService materielService) {
		this.materielService = materielService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Materiel>> getAllMateriel(){
		List<Materiel> materiels = materielService.findAllMateriels();
		return new ResponseEntity<>(materiels, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Materiel> getMaterielById(@PathVariable("id") Long id){
		Materiel materiel = materielService.findMateriel(id);
		return new ResponseEntity<>(materiel, HttpStatus.OK);
	}
	
	@GetMapping("/findNom/{nom}")
	public ResponseEntity<Materiel> getMaterielByNom(@PathVariable("nom") String nom){
		Materiel materiel = materielService.findMaterielNom(nom);
		return new ResponseEntity<>(materiel, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Materiel> addMateriel(@RequestBody Materiel materiel){
		Materiel newMateriel = materielService.addMateriel(materiel);
		return new ResponseEntity<>(newMateriel, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Materiel> updateMateriel(@RequestBody Materiel materiel){
		Materiel updateMateriel = materielService.updateMateriel(materiel);
		return new ResponseEntity<>(updateMateriel, HttpStatus.OK);
	}
	 
	@DeleteMapping("/delete/{id}") 
	public ResponseEntity<?> deleteMateriel(@PathVariable("id") Long id){
		materielService.deleteMateriel(id); 
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
