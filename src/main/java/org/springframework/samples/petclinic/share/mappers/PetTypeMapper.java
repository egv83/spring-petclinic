package org.springframework.samples.petclinic.share.mappers;

import org.springframework.samples.petclinic.domain.model.PetType;
import org.springframework.samples.petclinic.infraestructure.persistence.PetTypeEntity;

public interface PetTypeMapper {

	PetType toModel(PetTypeEntity entity);

	PetTypeEntity toEntity(PetType model);

}
