package org.springframework.samples.petclinic.share.impl;

import org.springframework.samples.petclinic.domain.model.PetType;
import org.springframework.samples.petclinic.infraestructure.persistence.PetTypeEntity;
import org.springframework.samples.petclinic.share.mappers.PetTypeMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PetTypeMappetImpl implements PetTypeMapper {
	@Override
	public PetType toModel(PetTypeEntity entity) {
		return PetType.builder()
			.id(entity.getId())
			.name(entity.getName())
			.build();
	}

	@Override
	public PetTypeEntity toEntity(PetType model) {
		PetTypeEntity entity = new PetTypeEntity();
		if(Objects.isNull(model)){
			return null;
		}
		entity.setId(model.getId());
		entity.setName(model.getName());
		return entity;
	}
}
