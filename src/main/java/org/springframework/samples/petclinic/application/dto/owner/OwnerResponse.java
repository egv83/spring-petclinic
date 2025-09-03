package org.springframework.samples.petclinic.application.dto.owner;

import org.springframework.samples.petclinic.domain.model.Pet;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class OwnerResponse {

	private final Integer id;
	private final String firstName;
	private final String lastName;
	private final String address;
	private final String city;
	private final String telephone;
	private Set<Pet> pets = new LinkedHashSet<>();

	private OwnerResponse(Builder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;;
		this.address = builder.address;
		this.city = builder.city;
		this.telephone = builder.telephone;
		if(Objects.nonNull(builder.pets)){
			this.pets.addAll(builder.pets);
		}
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
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

	public Set<Pet> getPets() {
		return pets;
	}

	@Override
	public String toString() {
		return "OwnerResponse{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", address='" + address + '\'' +
			", city='" + city + '\'' +
			", telephone='" + telephone + '\'' +
			'}';
	}

	public static Builder builder(){
		return new Builder();
	}

	public static class Builder{
		private Integer id;
		private String firstName;
		private String lastName;
		private String address;
		private String city;
		private String telephone;
		private Set<Pet> pets;

		public Builder id(Integer id){
			this.id = id;
			return this;
		}

		public Builder firstName(String firstName){
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName){
			this.lastName = lastName;
			return this;
		}

		public Builder address(String address){
			this.address = address;
			return this;
		}

		public Builder city(String city){
			this.city = city;
			return this;
		}

		public Builder telephone(String telephone){
			this.telephone = telephone;
			return this;
		}

		public Builder pets(Set<Pet> pets){
			this.pets = pets;
			return this;
		}

		public OwnerResponse build(){
			return new OwnerResponse(this);
		}

	}

}
