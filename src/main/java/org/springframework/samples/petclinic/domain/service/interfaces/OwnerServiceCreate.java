package org.springframework.samples.petclinic.domain.service.interfaces;

import org.springframework.samples.petclinic.domain.model.Owner;

public interface OwnerServiceCreate {

	void saveOwner(Owner owner);

	void updateOwner(Owner owner, Integer id);

}
