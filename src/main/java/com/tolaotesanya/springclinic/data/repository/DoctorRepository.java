package com.tolaotesanya.springclinic.data.repository;

import com.tolaotesanya.springclinic.data.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
