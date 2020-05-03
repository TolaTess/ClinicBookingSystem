package com.tolaotesanya.springclinic.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "DOCTOR")
public class Doctor {

    @Id
    @Column(name = "DOCTOR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DOCTOR_NUMBER")
    private String doctorNumber;
    @Column(name = "DOCTOR_INFO")
    private String doctorInfo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    public String getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(String doctorInfo) {
        this.doctorInfo = doctorInfo;
    }
}
