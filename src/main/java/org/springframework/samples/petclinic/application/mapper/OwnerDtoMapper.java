package org.springframework.samples.petclinic.application.mapper;

import org.springframework.data.domain.Page;
import org.springframework.samples.petclinic.application.dto.owner.OwnerRequest;
import org.springframework.samples.petclinic.application.dto.owner.OwnerResponse;
import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.infraestructure.persistence.OwnerEntity;

public interface OwnerDtoMapper {

	Owner toModel(OwnerRequest request);

	OwnerResponse toResponse(Owner model);

//	Page<Owner> toModel(Page<OwnerEntity> entitie);
	Page<OwnerResponse> toResponsePage(Page<Owner> model);

}
