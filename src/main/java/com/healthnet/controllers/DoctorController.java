package com.healthnet.controllers;

import com.healthnet.domain.Doctor;
import com.healthnet.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    /*
    The {doctorId} tells the sys that what ever is there is the requested doctor Id
    However for that to work proporly I need the : @PathVariable(value = "doctorId") Long doctorId
    in order to actully pass the value into the method
     */
    @RequestMapping("/{doctorId}")
    public String index(@PathVariable(value = "doctorId") Long doctorId, Model model){
        Doctor doctorOne = doctorRepository.findOne(doctorId);
        model.addAttribute("doctor",doctorOne);
        return "views/doctor/index";
    }

}
