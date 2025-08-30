package org.springframework.samples.petclinic.domain.model;

import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.samples.petclinic.owner.Visit;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Pet {

	protected Integer id;
	protected String name;
	private LocalDate birthDate;
	private PetType type;
	private final Set<Visit> visits = new LinkedHashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public Set<Visit> getVisits() {
		return visits;
	}
}
