package com.dracoul.formations.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dracoul.formations.entity.Rdv;

public interface RdvRepo extends JpaRepository<Rdv, String> {
	
	void deleteRdvById(Long id);
	Optional<Rdv> findRdvById(Long id);
	List<Rdv> findRdvBySpecialite(String specialite);

}

