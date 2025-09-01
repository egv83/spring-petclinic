package org.springframework.samples.petclinic.domain.service.interfaces;

import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.model.Pet;

import java.util.Collection;

public interface PetService {

	void savePet(Pet pet);

	void addPetToOwner(Pet pet, Owner owner);

	Pet findPetById(Integer id);

	Collection<Pet> findPetsByOwner(Owner owner);

}
