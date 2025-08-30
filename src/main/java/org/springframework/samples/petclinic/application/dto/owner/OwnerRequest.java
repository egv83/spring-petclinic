package org.springframework.samples.petclinic.application.dto.owner;

public class OwnerRequest {
	private final String firstName;
	private final String lastName;
	private final String address;
	private final String city;
	private final String telefone;

	private OwnerRequest(Builder builder){
		this.firstName = builder.firstName;;
		this.lastName = builder.lastName;
		this.address = builder.address;
		this.city = builder.city;
		this.telefone = builder.telefone;
	}

	public static Builder builder(){
		return new Builder();
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

	public String getTelefone() {
		return telefone;
	}

	public static class Builder{
		private String firstName;
		private String lastName;
		private String address;
		private String city;
		private String telefone;

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

		public Builder telefone(String telefone){
			this.telefone = telefone;
			return this;
		}

		public OwnerRequest build(){
			return new OwnerRequest(this);
		}
	}
}
