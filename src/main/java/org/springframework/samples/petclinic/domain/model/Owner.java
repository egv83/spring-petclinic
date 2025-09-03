package org.springframework.samples.petclinic.domain.model;

import org.springframework.samples.petclinic.domain.model.base.Person;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Owner {

	private Integer id;
	private String firtsName;
	private String lastName;
	private String address;
	private String city;
	private String telephone;
	private Set<Pet> pets = new LinkedHashSet<>();

	public Owner(OwnerBuilder builder){
		this.id = builder.id;
		this.firtsName = builder.firtsName;
		this.lastName = builder.lastName;
		this.address = builder.address;
		this.city = builder.city;
		this.telephone = builder.telephone;
		if(Objects.nonNull(builder.pets)){
			this.pets.addAll(builder.pets);
		}
	}

	public void addPet(Pet pet){
		if(Objects.isNull(pet.getOwner())){
			pet.setOwner(this);
		}
		this.pets.add(pet);
	}

	public Integer getId() {
		return id;
	}

	public String getFirtsName() {
		return firtsName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

//	public void setAddress(String address) {
//		this.address = address;
//	}

	public String getCity() {
		return city;
	}

//	public void setCity(String city) {
//		this.city = city;
//	}

	public String getTelephone() {
		return telephone;
	}

//	public void setTelephone(String telephone) {
//		this.telephone = telephone;
//	}

	public Set<Pet> getPets() {
		return pets;
	}

	@Override
	public String toString() {
		return "Owner{" +
			"address='" + address + '\'' +
			", city='" + city + '\'' +
			", telephone='" + telephone + '\'' +
			'}';
	}

	public static OwnerBuilder builder(){
		return new OwnerBuilder();
	}

	public static class OwnerBuilder{
		private Integer id;
		private String firtsName;
		private String lastName;
		private String address;
		private String city;
		private String telephone;
		private Set<Pet> pets;


		public OwnerBuilder id(Integer id){
			this.id = id;
			return this;
		}

		public OwnerBuilder firtsName(String firtsName){
			this.firtsName = firtsName;
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

		public OwnerBuilder telephone(String telephone){
			this.telephone = telephone;
			return this;
		}

		public OwnerBuilder pets(Set<Pet> pets){
			this.pets = pets;
			return this;
		}

		public Owner build(){
			return new Owner(this);
		}

	}

}
