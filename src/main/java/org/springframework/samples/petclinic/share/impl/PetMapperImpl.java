package org.springframework.samples.petclinic.share.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.samples.petclinic.domain.model.Pet;
import org.springframework.samples.petclinic.infraestructure.persistence.PetEntity;
import org.springframework.samples.petclinic.share.mappers.OwnerMapper;
import org.springframework.samples.petclinic.share.mappers.PetMapper;
import org.springframework.samples.petclinic.share.mappers.PetTypeMapper;
import org.springframework.samples.petclinic.share.mappers.VisitMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class PetMapperImpl implements PetMapper {

	private final OwnerMapper ownerMapper;
	private final VisitMapper visitMapper;
	private final PetTypeMapper petTypeMapper;

	public PetMapperImpl(@Lazy OwnerMapper ownerMapper, VisitMapper visitMapper, PetTypeMapper petTypeMapper) {
		this.ownerMapper = ownerMapper;
		this.visitMapper = visitMapper;
		this.petTypeMapper = petTypeMapper;
	}

	@Override
	public Pet toModel(PetEntity entity) {
		return Pet.builder()
			.name(entity.getName())
			.birthDate(entity.getBirthDate())
			.type(petTypeMapper.toModel(entity.getType()))
			.owner(ownerMapper.toModel(entity.getOwner()))
//			.visits()
			.build();
	}

	@Override
	public PetEntity toEntity(Pet model) {
		PetEntity entity = new PetEntity();
		entity.setName(model.getName());
		entity.setBirthDate(model.getBirthDate());
		entity.setType(petTypeMapper.toEntity(model.getType()));
		entity.setOwner(ownerMapper.toEntity(model.getOwner()));
		return entity;
	}

	@Override
	public Set<Pet> toSetModel(Set<PetEntity> entities) {
		if(Objects.isNull(entities) || entities.isEmpty()){
			return new HashSet<>();
		}

		Set<Pet> set = new LinkedHashSet<>();
		for(PetEntity petEntity: entities){
			set.add(toModel(petEntity));
		}
		return set;
	}

	@Override
	public Set<PetEntity> toSetEntity(Set<Pet> models) {
		if(Objects.isNull(models) || models.isEmpty()){
			return new HashSet<>();
		}
		Set<PetEntity> petEntities = new HashSet<>();
		for(Pet pet: models){
			petEntities.add(toEntity(pet));
		}
		return petEntities;
	}
}
