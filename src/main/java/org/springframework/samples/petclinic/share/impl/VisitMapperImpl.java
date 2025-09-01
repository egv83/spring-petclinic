package org.springframework.samples.petclinic.share.impl;

import org.springframework.samples.petclinic.domain.model.Visit;
import org.springframework.samples.petclinic.infraestructure.persistence.VisitEntity;
import org.springframework.samples.petclinic.share.mappers.VisitMapper;
import org.springframework.stereotype.Component;

@Component
public class VisitMapperImpl implements VisitMapper {

//	@Override
	public Visit toModel(VisitEntity entity) {
		return Visit.builder()
			.id(entity.getId())
			.date(entity.getDate())
			.description(entity.getDescription())
			.build();
	}

//	@Override
	public VisitEntity toEntity(Visit model) {
		VisitEntity entity = new VisitEntity();
		entity.setId(model.getId());
		entity.setDate(model.getDate());
		entity.setDescription(model.getDescription());
		return entity;
	}
}
