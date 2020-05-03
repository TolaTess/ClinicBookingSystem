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
    private long roomId;
    @Column(name="CUSTOMER_ID")
    private long guestId;
    @Column(name="APP_DATE")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
