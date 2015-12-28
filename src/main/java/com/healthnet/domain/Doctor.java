package com.healthnet.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ormarr on 12/28/2015.
 */
@Entity
public class Doctor {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @ManyToMany(mappedBy = "doctors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MedicalHistory> patients = new ArrayList<MedicalHistory>();

    public Doctor(String username, String password){
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

    public List<MedicalHistory> getPatients() {
        return patients;
    }



    public void setPatients(List<MedicalHistory> patients) {
        this.patients = patients;
    }

    public void addPatient(MedicalHistory patient){
        patient.getDoctors().add(this);
        patients.add(patient);
    }
}
