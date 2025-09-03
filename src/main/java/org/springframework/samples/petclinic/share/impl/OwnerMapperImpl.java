package org.springframework.samples.petclinic.share.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.infraestructure.persistence.OwnerEntity;
import org.springframework.samples.petclinic.share.mappers.OwnerMapper;
import org.springframework.samples.petclinic.share.mappers.PetMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OwnerMapperImpl implements OwnerMapper{

	private final PetMapper petMapper;

	public OwnerMapperImpl(@Lazy PetMapper petMapper) {
		this.petMapper = petMapper;
	}

	@Override
	public Owner toModel(OwnerEntity entity) {

		return Owner.builder()
			.id(entity.getId())
			.firtsName(entity.getFirstName())
			.lastName(entity.getLastName())
			.address(entity.getAddress())
			.city(entity.getCity())
			.telephone(entity.getTelephone())
			.pets(petMapper.toSetModel(entity.getPets()))
			.build();
	}

	@Override
	public OwnerEntity toEntity(Owner model) {
		OwnerEntity entity = new OwnerEntity();
		entity.setFirstName(model.getFirtsName());
		entity.setLastName(model.getLastName());
		entity.setAddress(model.getAddress());
		entity.setCity(model.getCity());
		entity.setTelephone(model.getTelephone());
		return entity;
	}

	@Override
	public Page<Owner> toPageModel(Page<OwnerEntity> entity) {
		if(Objects.isNull(entity)){
			return Page.empty();
		}
		return entity.map(this::toModel);
	}

	@Override
	public Collection<Owner> toColectionModel(Collection<OwnerEntity> entity) {
		if(Objects.isNull(entity)){
			return new ArrayList<>();
		}

		return entity.stream()
			.map(this::toModel)
			.collect(Collectors.toList());
	}

//	@Override
//	public Set<Owner> toSetModel(Set<Owner> entoties) {
//		return Set.of();
//	}

}
