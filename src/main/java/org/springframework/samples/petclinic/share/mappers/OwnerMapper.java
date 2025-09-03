package org.springframework.samples.petclinic.share.mappers;

import org.springframework.data.domain.Page;
import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.infraestructure.persistence.OwnerEntity;

import java.util.Collection;


public interface OwnerMapper {

	Owner toModel(OwnerEntity entity);

	OwnerEntity toEntity(Owner model);

	Page<Owner> toPageModel(Page<OwnerEntity> entity);

	Collection<Owner> toColectionModel(Collection<OwnerEntity> entity);

}
