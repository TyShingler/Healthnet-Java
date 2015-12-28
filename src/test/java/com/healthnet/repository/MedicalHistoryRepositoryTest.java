package com.healthnet.repository;

import com.healthnet.HealthnetApplication;
import com.healthnet.domain.Doctor;
import com.healthnet.domain.MedicalHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ormarr on 12/28/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthnetApplication.class)
@WebAppConfiguration
@Transactional
public class MedicalHistoryRepositoryTest {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Test
    public void MedicalHistoryRepositoryTest(){

        Doctor doctorOne = new Doctor("One", "One");
        Doctor doctorTwo = new Doctor("Two", "Two");

        MedicalHistory medicalHistory = new MedicalHistory("JohnDow");
        medicalHistory.getDoctors().add(doctorOne);
        medicalHistory.getDoctors().add(doctorTwo);

        medicalHistoryRepository.save(medicalHistory);

        MedicalHistory foundMedical = medicalHistoryRepository.findOne(medicalHistory.getId());

        assertNotNull(foundMedical);
        assertEquals(medicalHistory, foundMedical);
        assertNotNull(foundMedical.getDoctors());
        assertEquals(foundMedical.getDoctors(), medicalHistory.getDoctors());

    }
}
