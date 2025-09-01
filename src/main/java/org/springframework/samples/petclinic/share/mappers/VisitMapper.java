package org.springframework.samples.petclinic.share.mappers;

import org.springframework.samples.petclinic.domain.model.Visit;
import org.springframework.samples.petclinic.infraestructure.persistence.VisitEntity;

public interface VisitMapper {

	Visit toModel(VisitEntity entity);

	VisitEntity toEntity(Visit model);

}
