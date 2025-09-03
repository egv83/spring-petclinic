package org.springframework.samples.petclinic.domain.service.strategy;

import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.model.Pet;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PetXNombreStrategy implements BuscarPetStrategy {

	@Override
	public Collection<Pet> buscarPets(Owner owner, String nombrePet) {
		List<Pet> mascota = owner.getPets().stream()
			.filter(pet -> pet.getName().equalsIgnoreCase(nombrePet))
			.collect(Collectors.toList());
		return mascota;
	}

}
