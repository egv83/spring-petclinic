package org.springframework.samples.petclinic.application.mapper.iml;

import org.springframework.samples.petclinic.application.dto.pet.PetResponse;
import org.springframework.samples.petclinic.application.mapper.PetDtoMapper;
import org.springframework.samples.petclinic.domain.model.Pet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PetDtoMapperImpl implements PetDtoMapper {


	@Override
	public PetResponse toResponse(Pet model) {
		return PetResponse.builder()
			.name(model.getName())
			.birthDate(model.getBirthDate())
			//.type(model.getType().toString())
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
