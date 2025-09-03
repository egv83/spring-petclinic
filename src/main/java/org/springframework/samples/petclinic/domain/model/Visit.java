package org.springframework.samples.petclinic.domain.model;

import org.springframework.samples.petclinic.domain.model.base.Base;

import java.time.LocalDate;

public class Visit extends Base {

	private Integer id;
	private LocalDate date;
	private String description;
	private Pet pet;

	public Visit(VisitBuilder builder){
		this.id = builder.id;
		this.date = builder.date;
		this.description = builder.description;

	}

	public Visit(){
		this.date = LocalDate.now();
	}

	@Override
	public Integer getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

//	public void setDate(LocalDate date) {
//		this.date = date;
//	}

	public String getDescription() {
		return description;
	}

//	public void setDescription(String description) {
//		this.description = description;
//	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Visit{" +
			"id=" + id +
			", date=" + date +
			", description='" + description + '\'' +
			'}';
	}

	public static VisitBuilder builder(){
		return new VisitBuilder();
	}

	public static class VisitBuilder{
		private Integer id;
		private LocalDate date;
		private String description;
		private Pet pet;

		public VisitBuilder id(Integer id){
			this.id = id;
			return this;
		}

		public VisitBuilder date(LocalDate date){
			this.date = date;
			return this;
		}

		public VisitBuilder description(String description){
			this.description = description;
			return this;
		}

		public VisitBuilder pet(Pet pet){
			this.pet = pet;
			return this;
		}

		public Visit build(){
			return new Visit(this);
		}

	}
}
