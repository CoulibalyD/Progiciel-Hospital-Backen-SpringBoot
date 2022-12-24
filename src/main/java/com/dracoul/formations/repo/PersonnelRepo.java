package com.dracoul.formations.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dracoul.formations.entity.Personnel;

public interface PersonnelRepo extends JpaRepository<Personnel, Long>{
	
	void deletePersonnelById(Long id);
	Optional<Personnel> findPersonnelById(Long id);
	Personnel findByEmailAndPassword(String email,String password);

}
