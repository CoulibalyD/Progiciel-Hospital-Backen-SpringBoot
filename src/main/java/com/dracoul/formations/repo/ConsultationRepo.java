package com.dracoul.formations.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dracoul.formations.entity.Consultation;

public interface ConsultationRepo extends JpaRepository<Consultation, Long>{

	void deleteConsultationById(Long id);
	Optional<Consultation> findConsultationById(Long id);
	List<Consultation> findByMedecin(String medecin);
}
