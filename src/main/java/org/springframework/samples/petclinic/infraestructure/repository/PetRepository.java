package org.springframework.samples.petclinic.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.infraestructure.persistence.PetEntity;

import java.util.Optional;


public interface PetRepository extends JpaRepository<PetEntity, Integer> {

	Optional<PetEntity> findByName(String name);

}
