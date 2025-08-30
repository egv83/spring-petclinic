package org.springframework.samples.petclinic.domain.builder;

import org.springframework.samples.petclinic.infraestructure.persistence.PetEntity;
import org.springframework.samples.petclinic.owner.PetType;

import java.time.LocalDate;

public class PetBuilder {
	private Integer id;
	private String name;
	private PetType type;
	private LocalDate birthDate;

	private PetBuilder() {

	}

	public PetBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public PetBuilder name(String name) {
		this.name = name;
		return this;
	}

	public PetBuilder type(PetType type) {
		this.type = type;
		return this;
	}

	public PetBuilder birthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public PetEntity build(){
		PetEntity pet = new PetEntity();
		pet.setId(id);
		pet.setName(name);
		pet.setType(type);
		pet.setBirthDate(birthDate);
		return pet;
	}

	public static PetBuilder builder(){
		return new PetBuilder();
	}

}
