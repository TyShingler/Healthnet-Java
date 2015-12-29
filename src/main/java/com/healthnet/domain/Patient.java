package com.healthnet.domain;

import javax.persistence.*;


@Entity
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "MEDICAL_HISTORY_ID")
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

/*------NOTES-----------------------------------------------------------------------------------------------------------
        -Detached Entity Error
    -Problem- Error in start up about the relationship between Patient and MedicalHistory. Happens when you are adding
    the MedicalHistory to the Patient

    -Solution-
 */