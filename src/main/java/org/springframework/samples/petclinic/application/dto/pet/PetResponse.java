package org.springframework.samples.petclinic.application.dto.pet;

import java.time.LocalDate;

public class PetResponse {

	private final Integer id;
	private final String name;
	private final String  type;
	private final LocalDate birthDate;
	private final Integer ownerId;

	private PetResponse(Builder builder){
		this.id = builder.id;
		this.name = builder.name;
		this.type = builder.type;
		this.birthDate = builder.birthDate;
		this.ownerId = builder.ownerId;
	}

	public static Builder builder(){
		return new Builder();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public static class Builder {

		private Integer id;
		private String name;
		private String  type;
		private LocalDate birthDate;
		private Integer ownerId;

		public Builder id(Integer id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Builder ownerId(Integer ownerId){
			this.ownerId = ownerId;
			return this;
		}

		public PetResponse build() {
			return new PetResponse(this);
		}

	}
}
