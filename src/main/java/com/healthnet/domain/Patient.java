package com.healthnet.domain;

import javax.persistence.*;


@Entity
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private MedicalHistory medicalHistory;

    public Patient() {
    }

    public Patient(String username, String password){
        setUsername(username);
        setPassword(password);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
