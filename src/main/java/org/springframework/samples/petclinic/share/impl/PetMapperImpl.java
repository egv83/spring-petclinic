package org.springframework.samples.petclinic.share.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.samples.petclinic.domain.model.Pet;
import org.springframework.samples.petclinic.infraestructure.persistence.PetEntity;
import org.springframework.samples.petclinic.share.mappers.OwnerMapper;
import org.springframework.samples.petclinic.share.mappers.PetMapper;
import org.springframework.samples.petclinic.share.mappers.VisitMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class PetMapperImpl implements PetMapper {

	private final OwnerMapper ownerMapper;
	private final VisitMapper visitMapper;

	public PetMapperImpl(@Lazy OwnerMapper ownerMapper, VisitMapper visitMapper) {
		this.ownerMapper = ownerMapper;
		this.visitMapper = visitMapper;
	}

	@Override
	public Pet toModel(PetEntity entity) {
		return Pet.builder()
			.name(entity.getName())
			.birthDate(entity.getBirthDate())
			.type(entity.getType())
//			.visits()
			.build();
	}

	@Override
	public PetEntity toEntity(Pet model) {
		PetEntity entity = new PetEntity();
		entity.setName(model.getName());
		entity.setBirthDate(model.getBirthDate());
		entity.setType(model.getType());
		return entity;
	}

	@Override
	public Set<Pet> toSetModel(Set<PetEntity> entities) {
		if(Objects.isNull(entities)){
			return null;
		}

		Set<Pet> set = new LinkedHashSet<>();
		for(PetEntity petEntity: entities){
			set.add(toModel(petEntity));
		}
		return Set.of();
	}
}
