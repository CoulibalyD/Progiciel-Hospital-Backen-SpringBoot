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

import com.dracoul.formations.entity.Consultation;
import com.dracoul.formations.service.ConsultationService;

@RestController
@RequestMapping("/consultation")
public class ConsultationRessource {
	
private final ConsultationService consultationService;
	
	public ConsultationRessource(ConsultationService consultationService) {
		this.consultationService = consultationService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Consultation>> getAllConsultation(){
		List<Consultation> consultations = consultationService.findAllConsultations();
		return new ResponseEntity<>(consultations, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Consultation> getConsultationById(@PathVariable("id") Long id){
		Consultation consultation = consultationService.findConsultationById(id);
		return new ResponseEntity<>(consultation, HttpStatus.OK);
	}
	
	@GetMapping("/findS/{medecin}")
	public ResponseEntity<List<Consultation>> findByMedecin(@PathVariable("medecin") String medecin){
		List<Consultation> consultation = consultationService.findByMedecin(medecin);
		return new ResponseEntity<>(consultation, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Consultation> addConsultation(@RequestBody Consultation consultation){
		Consultation newConsultation = consultationService.addConsultation(consultation);
		return new ResponseEntity<>(newConsultation, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Consultation> updateEmployee(@RequestBody Consultation consultation){
		Consultation updateConsultation = consultationService.updateConsultation(consultation);
		return new ResponseEntity<>(updateConsultation, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}") 
	public ResponseEntity<?> deleteConsultation(@PathVariable("id") Long id){
		consultationService.deleteConsultation(id); 
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
}
