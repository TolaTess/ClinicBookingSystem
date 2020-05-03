package com.tolaotesanya.springclinic.data.repository;

import com.tolaotesanya.springclinic.data.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
