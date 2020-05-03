package com.tolaotesanya.springclinic.data.repository;

import com.tolaotesanya.springclinic.data.entity.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends PagingAndSortingRepository<Patient, Long> {

}
