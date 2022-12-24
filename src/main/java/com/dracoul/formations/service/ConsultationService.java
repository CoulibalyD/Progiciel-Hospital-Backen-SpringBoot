package com.dracoul.formations.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dracoul.formations.entity.Consultation;
import com.dracoul.formations.exception.UserNotFoundException;
import com.dracoul.formations.repo.ConsultationRepo;

@Service
@Transactional
public class ConsultationService {
	
	private ConsultationRepo consultationRepo;
	
	@Autowired
	public ConsultationService(ConsultationRepo consultationRepo) {
		this.consultationRepo = consultationRepo;	
	}
	
	public List<Consultation> findByMedecin(String medecin) {
		return consultationRepo.findByMedecin(medecin); 
	}
	
	public Consultation addConsultation(Consultation consultation) {
		consultation.setConsultationCode(UUID.randomUUID().toString());
		return consultationRepo.save(consultation);
	}
	
	public List<Consultation>findAllConsultations(){
		return consultationRepo.findAll(); 
	}
	
	public Consultation updateConsultation(Consultation consultation) {
		return consultationRepo.save(consultation);
	}
	
	public Consultation findConsultationById(Long id) {
		return consultationRepo.findConsultationById(id)
				.orElseThrow(() -> new UserNotFoundException("Consulation by id "+ id + "was not found")); 
	}
	
	public void deleteConsultation(Long id) {
		consultationRepo.deleteConsultationById(id);
	}

}
