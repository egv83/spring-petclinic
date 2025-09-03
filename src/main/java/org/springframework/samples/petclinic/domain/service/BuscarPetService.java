package org.springframework.samples.petclinic.domain.service;

import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.model.Pet;
import org.springframework.samples.petclinic.domain.service.strategy.BuscarPetStrategy;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BuscarPetService {

	private BuscarPetStrategy buscarPetStrategy;

	public void setBuscarPetStrategy(BuscarPetStrategy buscarPetStrategy) {
		this.buscarPetStrategy = buscarPetStrategy;
	}

	public Collection<Pet> buscarMascota(Owner owner, String criterio){
		if(buscarPetStrategy == null){
			throw new IllegalStateException("Busqueda Strategy no asignada");
		}
		return buscarPetStrategy.buscarPets(owner,criterio);
	}

}
