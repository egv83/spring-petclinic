package org.springframework.samples.petclinic.application.controller;

import org.springframework.samples.petclinic.application.dto.owner.CreateOwnerConPetRequest;
import org.springframework.samples.petclinic.application.mapper.OwnerDtoMapper;
import org.springframework.samples.petclinic.application.mapper.PetDtoMapper;
import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.model.Pet;
import org.springframework.samples.petclinic.domain.service.facade.PetClinicFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facade/")
public class OwnerRestControllerFacade {

	private final PetClinicFacade petClinicFacade;
	private final OwnerDtoMapper ownerDtoMapper;
	private final PetDtoMapper petDtoMapper;

	public OwnerRestControllerFacade(PetClinicFacade petClinicFacade, OwnerDtoMapper ownerDtoMapper, PetDtoMapper petDtoMapper) {
		this.petClinicFacade = petClinicFacade;
		this.ownerDtoMapper = ownerDtoMapper;
		this.petDtoMapper = petDtoMapper;
	}

	@PostMapping("owners-pets")
	public void crearDuenioYMascota(@RequestBody CreateOwnerConPetRequest request){
		Owner owner = ownerDtoMapper.toModel(request);
		Pet pet = petDtoMapper.toModel(request);

		petClinicFacade.createOwnerWithPet(owner,pet);
	}

}
