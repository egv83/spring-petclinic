package org.springframework.samples.petclinic.application.dto.owner;

public class OwnerResponse {

	private final Integer id;
	private final String firstName;
	private final String lastName;
	private final String address;
	private final String city;
	private final String telefone;

	private OwnerResponse(Builder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;;
		this.address = builder.address;
		this.city = builder.city;
		this.telefone = builder.telefone;
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

	public String getTelefone() {
		return telefone;
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
		private String telefone;

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

		public Builder telefone(String telefone){
			this.telefone = telefone;
			return this;
		}

		public OwnerResponse build(){
			return new OwnerResponse(this);
		}

	}

}
