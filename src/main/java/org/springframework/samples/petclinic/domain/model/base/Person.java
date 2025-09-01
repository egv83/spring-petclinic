package org.springframework.samples.petclinic.domain.model.base;

public class Person extends Base{
	private String firtsName;
	private String lastName;

	public String getFirtsName() {
		return firtsName;
	}

	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
