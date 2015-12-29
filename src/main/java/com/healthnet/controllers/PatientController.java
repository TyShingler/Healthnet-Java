package com.healthnet.controllers;

import com.healthnet.domain.Patient;
import com.healthnet.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    /*
    See DoctorController
     */
    @RequestMapping("/{patientId}")
    public String index(@PathVariable(value = "patientId") Long patientId, Model model){
        Patient patient = patientRepository.findOne(patientId);
        model.addAttribute("patient", patientId);
        return "views/doctor/index";
    }
}
