package org.springframework.samples.petclinic.domain.service.strategy;

import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.model.Pet;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PetXOwnerStrategy implements BuscarPetStrategy{

	@Override
	public Collection<Pet> buscarPets(Owner owner, String nombreOwner) {

		List<Pet> mascota = owner.getPets().stream()
			.filter(
				pet -> pet.getOwner().getFirtsName().equalsIgnoreCase(nombreOwner) ||
							pet.getOwner().getLastName().equalsIgnoreCase(nombreOwner)
			)
			.collect(Collectors.toUnmodifiableList());
		return mascota;
	}

}
