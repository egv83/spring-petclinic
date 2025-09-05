package org.springframework.samples.petclinic.domain.service;

import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.model.Pet;
import org.springframework.samples.petclinic.domain.service.interfaces.PetService;
import org.springframework.samples.petclinic.infraestructure.repository.PetRepository;
import org.springframework.samples.petclinic.share.mappers.PetMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

	private final PetRepository petRepository;
	private final PetMapper petMapper;

	public PetServiceImpl(PetRepository petRepository, PetMapper petMapper) {
		this.petRepository = petRepository;
		this.petMapper = petMapper;
	}

	@Override
	public void savePet(Pet pet) {
		var petTmp = petRepository.findByName(pet.getName());
		if(petTmp.isPresent()){
			throw new IllegalStateException("La mascota ya exixte");
		}

		petRepository.save(
			petMapper.toEntity(pet)
		);

	}

	@Override
	public void addPetToOwner(Pet pet, Owner owner) {

	}

	@Override
	public Pet findPetById(Integer id) {
		return null;
	}

	@Override
	public Collection<Pet> findPetsByOwner(Owner owner) {
		return List.of();
	}
}
