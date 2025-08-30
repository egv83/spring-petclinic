package org.springframework.samples.petclinic.domain.builder;


import org.springframework.samples.petclinic.infraestructure.persistence.PetTypeEntity;

public class PetTypeBuilder {

	private Integer id;
	private String name;

	private PetTypeBuilder(){

	}

	public PetTypeBuilder id(Integer id){
		this.id = id;
		return this;
	}

	public PetTypeBuilder name(String name){
		this.name = name;
		return this;
	}

	public PetTypeEntity build(){
		PetTypeEntity petType = new PetTypeEntity();
		petType.setId(id);
		petType.setName(name);
		return petType;
	}

	public PetTypeBuilder builder(){
		return new PetTypeBuilder();
	}

}
