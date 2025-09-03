package org.springframework.samples.petclinic.domain.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.domain.model.Owner;

import java.util.Collection;
import java.util.Optional;

public interface OwnerServiceFind {

	Owner findOwnerById(Integer id);

//	Page<Owner> findPaginatedForOwnersLastName(int page, String lastName);

	Collection<Owner> findByLastNameStartingWith(String lastName);

	Page<Owner> findByLastNameStartingWith(String lastName, int page);

}
