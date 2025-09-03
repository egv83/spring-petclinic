package org.springframework.samples.petclinic.domain.service.strategy;

import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.model.Pet;

import java.util.Collection;

public interface BuscarPetStrategy {

	Collection<Pet> buscarPets(Owner owner, String criterio);

}
