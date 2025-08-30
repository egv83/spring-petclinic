package org.springframework.samples.petclinic.domain.builder;

import org.springframework.samples.petclinic.infraestructure.persistence.VisitEntity;

import java.time.LocalDate;

public class VisitBuilder {
	private Integer id;
	private LocalDate date;
	private String description;

	private VisitBuilder(){

	}

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

	public VisitEntity build(){
		VisitEntity visit = new VisitEntity();
		visit.setId(id);
		visit.setDate(date);
		visit.setDescription(description);
		return visit;
	}

	public static VisitBuilder builder(){
		return new VisitBuilder();
	}

}
