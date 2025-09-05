package org.springframework.samples.petclinic.application.mapper;

import org.springframework.samples.petclinic.application.dto.owner.CreateOwnerConPetRequest;
import org.springframework.samples.petclinic.application.dto.pet.PetResponse;
import org.springframework.samples.petclinic.domain.model.Pet;

import java.util.Collection;

public interface PetDtoMapper {

	PetResponse toResponse(Pet model);
	Pet toModel(CreateOwnerConPetRequest request);

	Collection<PetResponse> toCollectionResponse(Collection<Pet> models);
}
