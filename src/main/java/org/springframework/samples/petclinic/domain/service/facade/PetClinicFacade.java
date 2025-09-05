package org.springframework.samples.petclinic.domain.service.facade;

import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.model.Pet;
import org.springframework.samples.petclinic.domain.service.interfaces.OwnerServiceCreate;
import org.springframework.samples.petclinic.domain.service.interfaces.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetClinicFacade {

	private final OwnerServiceCreate ownerServiceCreate;
	private final PetService petService;

	public PetClinicFacade(OwnerServiceCreate ownerServiceCreate, PetService petService) {
		this.ownerServiceCreate = ownerServiceCreate;
		this.petService = petService;
	}

	public void createOwnerWithPet(Owner owner, Pet pet){

		owner.addPet(pet);
		ownerServiceCreate.saveOwner(owner);

	}

}
