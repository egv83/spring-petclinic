/*
 * Copyright 2012-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.infraestructure.persistence;

import java.util.*;

import org.springframework.samples.petclinic.infraestructure.persistence.base.PersonEntity;

/**
 * Simple JavaBean domain object representing an owner.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Oliver Drotbohm
 * @author Wick Dynex
 */
//@Entity
//@Table(name = "owners")
public class OwnerEntity extends PersonEntity {

//	@Column(name = "address")
	private String address;

//	@Column(name = "city")
	private String city;

//	@Column(name = "telephone")
	private String telephone;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner")
//	@OrderBy("name")
	private Set<PetEntity> pets = new LinkedHashSet<>();

	public OwnerEntity(){

	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getTelephone() {
		return telephone;
	}

	//para inmutabilidd de datos,
	// los datos no podran ser cambiados en el transcurso desde la BDD
	public Set<PetEntity> getPets() {
		return Collections.unmodifiableSet(pets);
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setPets(Set<PetEntity> pets) {
		this.pets = pets;
	}



}
