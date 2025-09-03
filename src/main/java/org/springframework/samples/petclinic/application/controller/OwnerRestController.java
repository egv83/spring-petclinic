package org.springframework.samples.petclinic.application.controller;

import org.springframework.samples.petclinic.application.dto.pet.PetResponse;
import org.springframework.samples.petclinic.application.mapper.PetDtoMapper;
import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.model.Pet;
import org.springframework.samples.petclinic.domain.service.BuscarPetService;
import org.springframework.samples.petclinic.domain.service.interfaces.OwnerServiceFind;
import org.springframework.samples.petclinic.domain.service.strategy.BuscarPetStrategy;
import org.springframework.samples.petclinic.domain.service.strategy.PetXNombreStrategy;
import org.springframework.samples.petclinic.domain.service.strategy.PetXOwnerStrategy;
import org.springframework.samples.petclinic.share.mappers.PetMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/strategy")
public class OwnerRestController {

	private final BuscarPetService buscarPetService;
	private final OwnerServiceFind ownerServiceFind;
	private final PetDtoMapper petDtoMapper;

	public OwnerRestController(BuscarPetService buscarPetService, OwnerServiceFind ownerServiceFind, PetDtoMapper petDtoMapper) {
		this.buscarPetService = buscarPetService;
		this.ownerServiceFind = ownerServiceFind;
		this.petDtoMapper = petDtoMapper;
	}

	public Collection<PetResponse> buscarPets(
		@PathVariable("owner") String owner,
		@RequestParam String consulta,
		@RequestParam String tipoConsulta){

		Collection<PetResponse> petCollction = new ArrayList<>();

		Collection<Owner> ownerTMP = ownerServiceFind.findByLastNameStartingWith(owner);

		if(ownerTMP.isEmpty()){
			return new ArrayList<>();
		}

		if("nombrePet".equalsIgnoreCase(tipoConsulta)){
			buscarPetService.setBuscarPetStrategy(new PetXNombreStrategy());
		} else if ("nombreOwner".equalsIgnoreCase(tipoConsulta)) {
			buscarPetService.setBuscarPetStrategy(new PetXOwnerStrategy());
		}else {
			throw new IllegalArgumentException("Tipo de busqueda invalido");
		}

		for(Owner ow : ownerTMP){
			Collection<Pet> pets = buscarPetService.buscarMascota(ow,consulta);
			petCollction.addAll(
				petDtoMapper.toCollectionResponse(pets)
			);
		}

		return petCollction;

	}

}
