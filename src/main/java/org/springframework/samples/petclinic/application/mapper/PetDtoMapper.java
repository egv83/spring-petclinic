package org.springframework.samples.petclinic.application.mapper;

import org.springframework.samples.petclinic.application.dto.pet.PetResponse;
import org.springframework.samples.petclinic.domain.model.Pet;

import java.util.Collection;

public interface PetDtoMapper {

	PetResponse toResponse(Pet model);

	Collection<PetResponse> toCollectionResponse(Collection<Pet> models);
}
