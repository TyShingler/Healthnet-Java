package com.healthnet.controllers;

import com.healthnet.domain.Doctor;
import com.healthnet.domain.MedicalHistory;
import com.healthnet.domain.Patient;
import com.healthnet.repository.DoctorRepository;
import com.healthnet.repository.MedicalHistoryRepository;
import com.healthnet.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Controller
@Transactional
public class DataLoaderController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @PostConstruct
    public void load(){

//        Doctors
        Doctor doctorOne = new Doctor("doctorOne", "pass");
        Doctor doctorTwo = new Doctor("doctorTwo", "pass");

//        Patients
        Patient patientOne = new Patient("patientOne", "pass");
        Patient patientTwo = new Patient("patientTwo", "pass");

//        MedicalHistory
        MedicalHistory medOne = new MedicalHistory(patientOne.getUsername(), "One", "Number");
        MedicalHistory medTwo = new MedicalHistory(patientTwo.getUsername(), "Two", "Number");

        medOne.addDoctor(doctorOne);
        medOne.addDoctor(doctorTwo);

        medTwo.addDoctor(doctorTwo);
        medTwo.addDoctor(doctorOne);

        patientOne.setMedicalHistory(medOne);
        patientTwo.setMedicalHistory(medTwo);

//        Saving
        doctorRepository.save(doctorOne);
        doctorRepository.save(doctorTwo);

        medicalHistoryRepository.save(medOne);
        medicalHistoryRepository.save(medTwo);

        patientRepository.save(patientOne);
        patientRepository.save(patientTwo);

    }

}
