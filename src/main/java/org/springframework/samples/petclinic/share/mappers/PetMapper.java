package org.springframework.samples.petclinic.share.mappers;

import org.springframework.samples.petclinic.domain.model.Pet;
import org.springframework.samples.petclinic.infraestructure.persistence.PetEntity;

import java.util.Set;

public interface PetMapper {

	Pet toModel(PetEntity entity);

	PetEntity toEntity(Pet model);

	Set<Pet> toSetModel(Set<PetEntity> entities);
	Set<PetEntity> toSetEntity(Set<Pet> models);

}
