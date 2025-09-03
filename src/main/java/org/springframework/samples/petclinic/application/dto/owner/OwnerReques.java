package org.springframework.samples.petclinic.application.dto.owner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

public class OwnerReques implements Serializable {

//	@NotBlank
	private Integer id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String address;

	@NotBlank
	private String city;

	@NotBlank
	@Pattern(regexp = "\\d{10}", message = "{telephone.invalid}")
	private String telephone;

	public OwnerReques(){
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "OwnerReques{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", address='" + address + '\'' +
			", city='" + city + '\'' +
			", telephone='" + telephone + '\'' +
			'}';
	}
}
