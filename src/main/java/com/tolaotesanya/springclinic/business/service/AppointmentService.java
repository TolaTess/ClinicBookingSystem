package com.tolaotesanya.springclinic.business.service;

import com.tolaotesanya.springclinic.business.domain.BookAppointment;
import com.tolaotesanya.springclinic.data.entity.Appointment;
import com.tolaotesanya.springclinic.data.entity.Doctor;
import com.tolaotesanya.springclinic.data.entity.Patient;
import com.tolaotesanya.springclinic.data.repository.AppointmentRepository;
import com.tolaotesanya.springclinic.data.repository.DoctorRepository;
import com.tolaotesanya.springclinic.data.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AppointmentService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public AppointmentService(DoctorRepository doctorRepository, PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public List<BookAppointment> getBookAppointmentForDate(String dateString) {

        Date date = this.createDateFromDateString(dateString);
        //iterate all Doctors in the Repository
        Iterable<Doctor> doctors = this.doctorRepository.findAll();
        Map<Long, BookAppointment> bookAppointmentMap = new HashMap<>();
        //for each doctor in doctors repository
        //set doctor's information in BookAppointment object
        doctors.forEach(doctor -> {
            BookAppointment bookAppointment = new BookAppointment();
            bookAppointment.setDoctorId(doctor.getId());
            bookAppointment.setDoctorName(doctor.getName());
            bookAppointment.setDoctorNumber(doctor.getDoctorNumber());
            //put book appointment in a map using doctorId as key
            bookAppointmentMap.put(doctor.getId(), bookAppointment);
        });
        //iterate appointments repository using sql.date as declared in the repository method
        Iterable<Appointment> appointments = this.appointmentRepository.findByDate(new java.sql.Date(date.getTime()));
        if (null != appointments) {
            //for each appointment
            //check if patient is stored against it via patient repository
            //if patient present, set patient information to the
            //appointment in the bookApp map.
            appointments.forEach(appointment -> {
                Optional<Patient> patientResponse = this.patientRepository.findById(appointment.getPatientId());
                if (patientResponse.isPresent()) {
                    Patient patient = patientResponse.get();
                    BookAppointment bookAppointment = bookAppointmentMap.get(appointment.getId());
                    bookAppointment.setDate(date);
                    bookAppointment.setFirstName(patient.getFirstName());
                    bookAppointment.setLastName(patient.getLastName());
                    bookAppointment.setCustomerId(patient.getId());
                }

            });
        }
        //add all appointments in the map to bookAppointment list
        List<BookAppointment> bookAppointments = new ArrayList<>();
        for (Long doctorId : bookAppointmentMap.keySet()) {
            bookAppointments.add(bookAppointmentMap.get(doctorId));
        }
        return bookAppointments;
    }


    private Date createDateFromDateString(String dateString) {
        Date date = null;
        if(null!=dateString)
            try{
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        else{
            date = new Date();
        }
        return date;
    }

}
