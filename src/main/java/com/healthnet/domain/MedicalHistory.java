package com.healthnet.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity
public class MedicalHistory {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private Date dob;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "MedicalHistory_Doctor", joinColumns = {@JoinColumn(name = "MedicalHistory_ID")},
        inverseJoinColumns = {@JoinColumn(name = "Doctor_ID")})
    private List<Doctor> doctors = new ArrayList<Doctor>();

    public MedicalHistory() {
    }

    public MedicalHistory(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MedicalHistory(String username){
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addDoctor(Doctor doctor){
        doctor.getPatients().add(this);
        doctors.add(doctor);
    }
}