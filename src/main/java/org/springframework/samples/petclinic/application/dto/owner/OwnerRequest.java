package org.springframework.samples.petclinic.application.dto.owner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

public class OwnerRequest implements Serializable {

	@NotBlank
	private final Integer id;

	@NotBlank
	private final String firstName;

	@NotBlank
	private final String lastName;

	@NotBlank
	private final String address;

	@NotBlank
	private final String city;

	@NotBlank
	@Pattern(regexp = "\\d{10}", message = "{telephone.invalid}")
	private final String telephone;

	private OwnerRequest(Builder builder){
		this.id = builder.id;
		this.firstName = builder.firstName;;
		this.lastName = builder.lastName;
		this.address = builder.address;
		this.city = builder.city;
		this.telephone = builder.telephone;
	}

	public static Builder builder(){
		return new Builder();
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

	public static class Builder{
		private Integer id;
		private String firstName;
		private String lastName;
		private String address;
		private String city;
		private String telephone;

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

		public OwnerRequest build(){
			return new OwnerRequest(this);
		}
	}
}
