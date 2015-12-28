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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthnetApplication.class)
@WebAppConfiguration
@Transactional
public class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    public void DoctorRepositoryTest(){

        MedicalHistory patientOne = new MedicalHistory("One");
        MedicalHistory patientTwo = new MedicalHistory("Two");

        Doctor doctorOne = new Doctor("Tim","Heller");
        doctorOne.addPatient(patientOne);
        doctorOne.addPatient(patientTwo);

        doctorRepository.save(doctorOne);

        Doctor foundDoctor = doctorRepository.findOne(doctorOne.getId());

        assertNotNull(foundDoctor);
        assertEquals(doctorOne, foundDoctor);
        assertNotNull(foundDoctor.getPatients());
        assertEquals(foundDoctor.getPatients(), doctorOne.getPatients());

    }

}
