package com.dracoul.formations;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dracoul.formations.entity.Personnel;
import com.dracoul.formations.service.PersonnelService;
 
@RestController
@RequestMapping("/personnel")
public class PersonnelResource {

	private final PersonnelService personnelService;
	
	public PersonnelResource(PersonnelService personnelService) {
		this.personnelService = personnelService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Personnel>> getAllPersonnel(){
		List<Personnel> personnels = personnelService.findAllPersonnels();
		return new ResponseEntity<>(personnels, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Personnel> getPersonnelById(@PathVariable("id") Long id){
		Personnel personnel = personnelService.findPersonnelById(id);
		return new ResponseEntity<>(personnel, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Personnel> addEmployee(@RequestBody Personnel personnel){
		Personnel newPersonnel = personnelService.addPersonnel(personnel);
		return new ResponseEntity<>(newPersonnel, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Personnel> updateEmployee(@RequestBody Personnel personnel){
		Personnel updatePersonnel = personnelService.updatePersonnel(personnel);
		return new ResponseEntity<>(updatePersonnel, HttpStatus.OK);
	}
	
	@GetMapping("/authentification")
	public ResponseEntity<String> getPersonnelByEmailPassword(@RequestParam("email") String email,@RequestParam("password") String password) {
		return new ResponseEntity<String>(personnelService.getTypeUserByEmailAndPassword(email, password), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}") 
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
		personnelService.deletePersonnel(id); 
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
