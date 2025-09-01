package org.springframework.samples.petclinic.domain.model;

import org.springframework.samples.petclinic.owner.PetType;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Pet {

	private String name;
	private LocalDate birthDate;
	private PetType type;
	private Owner owner;
	private Set<Visit> visits = new LinkedHashSet<>();

	public Pet() {
	}

	public Pet(PetBuilder builder){
		this.name = builder.name;
		this.birthDate = builder.birthDate;
		this.type = builder.type;
		this.owner = builder.owner;
		if(Objects.nonNull(builder.visits)){
			this.visits.addAll(builder.visits);
		}

	}

	public void addVisit(Visit visit){
		if(Objects.isNull(visit)){
			visit.setPet(this);
		}
		this.visits.add(visit);
	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

//	public void setBirthDate(LocalDate birthDate) {
//		this.birthDate = birthDate;
//	}

	public PetType getType() {
		return type;
	}

//	public void setType(PetType type) {
//		this.type = type;
//	}

	public Set<Visit> getVisits() {
		return visits;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet{" +
			"name='" + name + '\'' +
			", birthDate=" + birthDate +
			", type=" + type +
			", visits=" + visits +
			'}';
	}

	public static PetBuilder builder(){
		return new PetBuilder();
	}

	public static class PetBuilder{
		private String name;
		private LocalDate birthDate;
		private PetType type;
		private Owner owner;
		private Set<Visit> visits;

		public PetBuilder name(String name) {
			this.name = name;
			return this;
		}

		public PetBuilder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public PetBuilder type(PetType type) {
			this.type = type;
			return this;
		}

		public PetBuilder owner(Owner owner){
			this.owner = owner;
			return this;
		}

		public PetBuilder visits(Set<Visit> visits){
			this.visits = visits;
			return this;
		}

		public Pet build(){
			return new Pet(this);
		}

	}

}
