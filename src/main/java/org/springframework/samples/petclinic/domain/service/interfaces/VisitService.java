package org.springframework.samples.petclinic.domain.service.interfaces;

import org.springframework.samples.petclinic.domain.model.Pet;
import org.springframework.samples.petclinic.domain.model.Visit;

import java.time.LocalDate;
import java.util.Collection;

public interface VisitService {

	void addVisit(Visit visit);

	Collection<Visit> findVisitByPet(Pet pet);

	Visit findVisitByDate(LocalDate date);
}
