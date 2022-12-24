package com.dracoul.formations.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dracoul.formations.entity.Materiel;

public interface MaterielRepo extends JpaRepository<Materiel, Long> {

	void deletePersonnelById(Long id);
	Optional<Materiel> findPersonnelById(Long id);
	Optional<Materiel> findPersonnelByNom(String nom);

	

}
