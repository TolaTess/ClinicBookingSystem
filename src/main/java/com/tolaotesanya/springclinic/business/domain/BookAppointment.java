package com.tolaotesanya.springclinic.business.domain;

import java.util.Date;

public class BookAppointment {

    private long doctorId;
    private long customerId;
    private String doctorName;
    private String doctorNumber;
    private String doctorInfo;
    private String firstName;
    private String lastName;
    private Date date;

    public String getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(String doctorInfo) {
        this.doctorInfo = doctorInfo;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
