package org.springframework.samples.petclinic.domain.builder;

import org.springframework.samples.petclinic.infraestructure.persistence.OwnerEntity;

public class OwnerBuilder {
	private Integer id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String telefone;

	private OwnerBuilder(){

	}

	public OwnerBuilder id(Integer id){
		this.id = id;
		return this;
	}

	public OwnerBuilder firstName(String firstName){
		this.firstName = firstName;
		return this;
	}

	public OwnerBuilder lastName(String lastName){
		this.lastName = lastName;
		return this;
	}

	public OwnerBuilder address(String address){
		this.address = address;
		return this;
	}

	public OwnerBuilder city(String city){
		this.city = city;
		return this;
	}

	public OwnerBuilder telefone(String telefone){
		this.telefone = telefone;
		return this;
	}

	public OwnerEntity build(){
		OwnerEntity owner = new OwnerEntity();

//		if(Objects.nonNull(id)){
			owner.setId(id);
//		}

		owner.setFirstName(firstName);
		owner.setLastName(lastName);
		owner.setAddress(address);
		owner.setCity(city);
		owner.setTelephone(telefone);

		return owner;
	}

	public static OwnerBuilder builder(){
		return new OwnerBuilder();
	}

}
