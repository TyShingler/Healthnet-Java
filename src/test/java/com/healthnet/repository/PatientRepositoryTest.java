package com.healthnet.repository;

import com.healthnet.HealthnetApplication;
import com.healthnet.domain.MedicalHistory;
import com.healthnet.domain.Patient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthnetApplication.class)
@WebAppConfiguration
@Transactional
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void repositoryTest(){

        String username = "JohnDow";
        String password = "password";
        String firstname = "John";
        String lastname = "Dow";
        // Make a patient and save it to the repo
        Patient patientOne = new Patient(username, password);
        MedicalHistory history = new MedicalHistory(username,firstname,lastname);
        patientOne.setMedicalHistory(history);
        patientRepository.save(patientOne);

        // Fint the patient in the repo

        Patient foundPatient = patientRepository.findOne(patientOne.getId());
        assertNotNull(foundPatient);
        assertEquals(patientOne,foundPatient);
        assertNotNull(foundPatient.getMedicalHistory());
        assertEquals(foundPatient.getMedicalHistory(), patientOne.getMedicalHistory());

    }

}
