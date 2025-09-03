package org.springframework.samples.petclinic.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.domain.model.Owner;
import org.springframework.samples.petclinic.domain.service.interfaces.OwnerServiceCreate;
import org.springframework.samples.petclinic.domain.service.interfaces.OwnerServiceFind;
import org.springframework.samples.petclinic.infraestructure.repository.OwnerRepository;
import org.springframework.samples.petclinic.share.mappers.OwnerMapper;
import org.springframework.samples.petclinic.share.mappers.PetMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class OwnerService implements OwnerServiceCreate, OwnerServiceFind {

	private final OwnerRepository ownerRepository;
	private final OwnerMapper ownerMapper;
	private final PetMapper petMapper;

	public OwnerService(OwnerRepository ownerRepository, OwnerMapper ownerMapper, PetMapper petMapper) {
		this.ownerRepository = ownerRepository;
		this.ownerMapper = ownerMapper;
		this.petMapper = petMapper;
	}

	@Override
	public void saveOwner(Owner owner) {

		var ownerTmp = ownerRepository.findByLastNameAndFirstName(owner.getLastName(), owner.getFirtsName());
		if(ownerTmp.isEmpty()){
			throw new IllegalStateException("Owner with this name already exists");
		}

		ownerRepository.save(
			ownerMapper.toEntity(owner)
		);


	}

	@Override
	public void updateOwner(Owner owner, Integer id) {

		var ownerTmp = ownerRepository.findById(id);
		if(ownerTmp.isPresent()){
			throw new IllegalArgumentException("Owner not found for update.");
		}

		Owner upddate = Owner.builder()
			.id(ownerTmp.get().getId())
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
		if(!ownerTmp.isPresent()){
			throw new IllegalArgumentException("Owner not found");
		}

		return ownerMapper.toModel(
			ownerRepository.findById(id).orElse(null)
		);
	}

	@Override
	public Collection<Owner> findByLastNameStartingWith(String lastName) {
		return ownerMapper.toColectionModel(
			ownerRepository.findByLastNameStartingWith(lastName)
		);
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
		Pageable pageable = PageRequest.of(page-1,pageSize);

//		var tmp = ownerRepository.findByLastNameStartingWithPageable(lastName,pageable);
//
//		var maper = ownerMapper.toPageModel(
//			ownerRepository.findByLastNameStartingWithPageable(lastName,pageable)
//		);

		return ownerMapper.toPageModel(
			ownerRepository.findByLastNameStartingWithPageable(lastName,pageable)
		);
	}

}
