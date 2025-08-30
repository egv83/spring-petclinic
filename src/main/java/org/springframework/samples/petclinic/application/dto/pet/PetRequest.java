package org.springframework.samples.petclinic.application.dto.pet;

import java.time.LocalDate;

public class PetRequest {

	private final String name;
	private final Integer typeId;
	private final LocalDate birthDate;

	private PetRequest(Builder builder){
		this.name = builder.name;
		this.typeId = builder.typeId;
		this.birthDate = builder.birthDate;
	}

	public static Builder builder(){
		return new Builder();
	}

	public String getName() {
		return name;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public static class Builder {

		private String name;
		private Integer typeId;
		private LocalDate birthDate;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder typeId(Integer typeId) {
			this.typeId = typeId;
			return this;
		}

		public Builder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public PetRequest build() {
			return new PetRequest(this);
		}
	}

}
