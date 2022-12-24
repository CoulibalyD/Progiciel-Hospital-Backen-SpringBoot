package com.dracoul.formations.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dracoul.formations.entity.Personnel;
import com.dracoul.formations.entity.Rdv;
import com.dracoul.formations.exception.UserNotFoundException;
import com.dracoul.formations.repo.RdvRepo;

@Service
@Transactional
public class RdvService {
private final RdvRepo rdvRepo ;
	Personnel personnelConnect;
	public Personnel getPersonnelConnect() {
		return personnelConnect;
	}

	public void setPersonnelConnect(Personnel personnelConnect) {
		this.personnelConnect = personnelConnect;
	}

	@Autowired
	public RdvService(RdvRepo rdvRepo) {
		this.rdvRepo = rdvRepo;	
	}
	
	public Rdv addRdv(Rdv rdv) {
		rdv.setRdvCode(UUID.randomUUID().toString());
		rdv.setPersonnel(personnelConnect);
		return rdvRepo.save(rdv);
	}
	
	public List<Rdv>findAllRdvs(){
		return rdvRepo.findAll(); 
	}
	
	public Rdv updateRdv(Rdv rdv) {
		return rdvRepo.save(rdv);
	}
	
	public Rdv findRdvById(Long id) {
		return rdvRepo.findRdvById(id)
				.orElseThrow(() -> new UserNotFoundException("Rdv by id "+ id + "was not found")); 
	}
	
	public List<Rdv> findRdvBySpecialite(String specialite) {
		return rdvRepo.findRdvBySpecialite(specialite); 
	}
	
	public void deleteRdv(Long id) {
		rdvRepo.deleteRdvById(id);
	}

}
