package com.tolaotesanya.springclinic.data.repository;

import com.tolaotesanya.springclinic.data.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    //method to access appointments by date variable
    List<Appointment> findByDate (Date date);
}
