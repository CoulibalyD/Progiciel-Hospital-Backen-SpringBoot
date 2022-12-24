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

import com.dracoul.formations.entity.Rdv;
import com.dracoul.formations.service.RdvService;

@RestController
@RequestMapping("/rdv")
public class RdvRessource {
	
private final RdvService rdvService;
	
	public RdvRessource(RdvService rdvService) {
		this.rdvService = rdvService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Rdv>> getAllPersonnel(){
		List<Rdv> rdvs = rdvService.findAllRdvs();
		return new ResponseEntity<>(rdvs, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Rdv> getRdvById(@PathVariable("id") Long id){
		Rdv rdv = rdvService.findRdvById(id);
		return new ResponseEntity<>(rdv, HttpStatus.OK);
	}
	
	@GetMapping("/findS/{specialite}")
	public ResponseEntity<List<Rdv>> findRdvBySpecialite(@PathVariable("specialite") String specialite){
		List<Rdv> rdvs = rdvService.findRdvBySpecialite(specialite);
		return new ResponseEntity<>(rdvs, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Rdv> addRdv(@RequestBody Rdv rdv){
		Rdv newRdv = rdvService.addRdv(rdv);
		return new ResponseEntity<>(newRdv, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Rdv> updateRdv(@RequestBody Rdv rdv){
		Rdv updateRdv = rdvService.updateRdv(rdv);
		return new ResponseEntity<>(updateRdv, HttpStatus.OK);
	}
	 
	@DeleteMapping("/delete/{id}") 
	public ResponseEntity<?> deleteRdv(@PathVariable("id") Long id){
		rdvService.deleteRdv(id); 
		return new ResponseEntity<>( HttpStatus.OK);
	}

}
