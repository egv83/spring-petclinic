package org.springframework.samples.petclinic.share.mappers;

import org.springframework.data.domain.Page;
import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.infraestructure.persistence.OwnerEntity;


public interface OwnerMapper {

	Owner toModel(OwnerEntity entity);

	OwnerEntity toEntity(Owner model);

	Page<Owner> toPageModel(Page<OwnerEntity> entity);

//	Set<Owner> toSetModel(Set<Owner> entoties);

}
