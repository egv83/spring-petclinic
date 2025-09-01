package org.springframework.samples.petclinic.application.mapper.iml;

import org.springframework.data.domain.Page;
import org.springframework.samples.petclinic.application.dto.owner.OwnerRequest;
import org.springframework.samples.petclinic.application.dto.owner.OwnerResponse;
import org.springframework.samples.petclinic.application.mapper.OwnerDtoMapper;
import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OwnerDtoMapperImpl implements OwnerDtoMapper {

	@Override
	public Owner toModel(OwnerRequest request) {
		return Owner.builder()
			.id(request.getId())
			.firtsName(request.getFirstName())
			.lastName(request.getLastName())
			.address(request.getAddress())
			.city(request.getCity())
			.telephone(request.getTelephone())
			.build();
	}

	@Override
	public OwnerResponse toResponse(Owner model) {
		return OwnerResponse.builder()
			.id(model.getId())
			.firstName(model.getFirtsName())
			.lastName(model.getLastName())
			.address(model.getAddress())
			.city(model.getCity())
			.telefone(model.getTelephone())
			.build();
	}

	@Override
	public Page<OwnerResponse> toResponsePage(Page<Owner> model){
		if(Objects.isNull(model)){
			return Page.empty();
		}
		return model.map(this::toResponse);
	}

}
