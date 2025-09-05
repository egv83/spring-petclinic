package org.springframework.samples.petclinic.application.mapper.iml;

import org.springframework.samples.petclinic.application.dto.owner.CreateOwnerConPetRequest;
import org.springframework.samples.petclinic.application.dto.pet.PetResponse;
import org.springframework.samples.petclinic.application.mapper.PetDtoMapper;
import org.springframework.samples.petclinic.domain.model.Pet;
import org.springframework.samples.petclinic.domain.model.PetType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class PetDtoMapperImpl implements PetDtoMapper {


	@Override
	public PetResponse toResponse(Pet model) {
		return PetResponse.builder()
			.name(model.getName())
			.birthDate(model.getBirthDate())
			.type(model.getType().toString())
			.ownerId(model.getOwner().getId())
			.build();
	}

	@Override
	public Pet toModel(CreateOwnerConPetRequest request) {
		return Pet.builder()
			.name(request.getPetName())
			.birthDate(request.getPetBirthDate())
			.type(
				PetType.builder()
					.name(request.getPetType())
					.build()
			)
			.build();
	}

	@Override
	public Collection<PetResponse> toCollectionResponse(Collection<Pet> models) {
		if(models.isEmpty()){
			return new ArrayList<>();
		}

		return models.stream()
			.map(this::toResponse)
			.collect(Collectors.toList());
	}


}
