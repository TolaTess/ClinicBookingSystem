package com.tolaotesanya.springclinic.data.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="APPOINTMENT")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="APPOINTMENT_ID")
    private long id;
    @Column(name="DOCTOR_ID")
    private long doctorId;
    @Column(name="CUSTOMER_ID")
    private long patientId;
    @Column(name="APP_DATE")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
