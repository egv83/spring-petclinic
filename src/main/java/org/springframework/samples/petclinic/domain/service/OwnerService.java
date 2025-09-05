package org.springframework.samples.petclinic.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.model.Pet;
import org.springframework.samples.petclinic.domain.model.PetType;
import org.springframework.samples.petclinic.domain.service.interfaces.OwnerServiceCreate;
import org.springframework.samples.petclinic.domain.service.interfaces.OwnerServiceFind;
import org.springframework.samples.petclinic.infraestructure.persistence.PetEntity;
import org.springframework.samples.petclinic.infraestructure.persistence.PetTypeEntity;
import org.springframework.samples.petclinic.infraestructure.repository.OwnerRepository;
import org.springframework.samples.petclinic.infraestructure.repository.PetRepository;
import org.springframework.samples.petclinic.infraestructure.repository.PetTypeRepository;
import org.springframework.samples.petclinic.share.mappers.OwnerMapper;
import org.springframework.samples.petclinic.share.mappers.PetTypeMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OwnerService implements OwnerServiceCreate, OwnerServiceFind {

	private final OwnerRepository ownerRepository;
	private final PetTypeRepository petTypeRepository;
	private final PetRepository petRepository;
	private final OwnerMapper ownerMapper;
	private final PetTypeMapper petTypeMapper;


	public OwnerService(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository, PetRepository petRepository, OwnerMapper ownerMapper, PetTypeMapper petTypeMapper) {
		this.ownerRepository = ownerRepository;
		this.petTypeRepository = petTypeRepository;
		this.petRepository = petRepository;
		this.ownerMapper = ownerMapper;
		this.petTypeMapper = petTypeMapper;
	}

	@Override
	public void saveOwner(Owner owner) {

		var ownerTmp = ownerRepository.findByLastNameAndFirstName(owner.getLastName(), owner.getFirtsName());

		if (ownerTmp.isPresent()) {
			throw new IllegalStateException("Owner with this name: " +owner.getFirtsName() +" "+owner.getLastName()+ " already exists");
		}

		Owner ownerSave = Owner.builder()
			.firtsName(owner.getFirtsName())
			.lastName(owner.getLastName())
			.address(owner.getAddress())
			.city(owner.getCity())
			.telephone(owner.getTelephone())
			.build();

		var ownerX = ownerRepository.save(ownerMapper.toEntity(ownerSave));

		for (Pet p : owner.getPets()) {
			PetTypeEntity ptSave = null;
			String type = p.getType().getName();
//			PetType pt = petTypeMapper.toModel(petTypeRepository.findPetTypeByName(type).get());

			var pt = petTypeRepository.findPetTypeByName(type);

			if (!pt.isPresent()) {
//				PetType px = PetType.builder()
//					.name(type)
//					.build();
				ptSave = petTypeRepository.save(
					petTypeMapper.toEntity(
						PetType.builder()
							.name(type)
							.build()
					)
				);
			} else {
				ptSave = pt.get();
			}

			PetEntity petSave = new PetEntity();
			petSave.setName(p.getName());
			petSave.setBirthDate(p.getBirthDate());
			petSave.setType(ptSave);
			petSave.setOwner(ownerX);

			petRepository.save(petSave);
		}

	}

	@Override
	public void updateOwner(Owner owner, Integer id) {

		var ownerTmp = ownerRepository.findById(id);
		if (!ownerTmp.isPresent()) {
			throw new IllegalArgumentException("Owner not found for update.");
		}

		Owner ownerEncontrado = ownerMapper.toModel(ownerTmp.get());

		Owner upddate = Owner.builder()
			.id(ownerEncontrado.getId())
			.firtsName(owner.getFirtsName())
			.lastName(owner.getLastName())
			.address(owner.getAddress())
			.city(owner.getCity())
			.telephone(owner.getTelephone())
			.pets(owner.getPets())
			.build();

		ownerRepository.save(
			ownerMapper.toEntity(upddate)
		);

	}

	@Override
	public Owner findOwnerById(Integer id) {

		var ownerTmp = ownerRepository.findById(id);
		if (!ownerTmp.isPresent()) {
			throw new IllegalArgumentException("Owner not found");
		}

		return ownerMapper.toModel(
			ownerRepository.findById(id).orElse(null)
		);
	}

	@Override
	public Collection<Owner> findAll() {
		Collection<Owner> owners = ownerMapper.toColectionModel(ownerRepository.findAll());

//		return ownerMapper.toColectionModel(
//			ownerRepository.findAll()
//		);
		return owners;
	}

//	@Override
//	public Page<Owner> findPaginatedForOwnersLastName(int page, String lastName) {
//		int pageSize = 5;
//		Pageable pageable = PageRequest.of(page-1,pageSize);
//
//		return ownerMapper.toModel(
//			ownerRepository.findByLastNameStartingWith(lastName,pageable)
//		);
//	}

	@Override
//	@Transactional(readOnly = true)
	public Page<Owner> findByLastNameStartingWith(String lastName, int page) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);

//		var tmp = ownerRepository.findByLastNameStartingWithPageable(lastName,pageable);
//
//		var maper = ownerMapper.toPageModel(
//			ownerRepository.findByLastNameStartingWithPageable(lastName,pageable)
//		);

		return ownerMapper.toPageModel(
			ownerRepository.findByLastNameStartingWith(lastName, pageable)
		);
	}

}
