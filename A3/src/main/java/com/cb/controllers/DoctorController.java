package com.cb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cb.domain.Doctor;
import com.cb.services.DoctorService;

@Controller
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @RequestMapping("user_doctor_form")
    public ModelAndView getForm(@ModelAttribute Doctor doctor) {
        return new ModelAndView("user_doctor_form");
    }

    @RequestMapping("user_doctor_register")
    public ModelAndView registerDoctor(@ModelAttribute Doctor doctor) {
        doctorService.insertRow(doctor);
        return new ModelAndView("redirect:user_doctor_list");
    }

    @RequestMapping("user_doctor_list")
    public ModelAndView getList() {
        List doctorList = doctorService.getList();
        return new ModelAndView("user_doctor_list", "doctorList", doctorList);
    }

    @RequestMapping("user_doctor_delete")
    public ModelAndView deleteDoctor(@RequestParam int id) {
        doctorService.deleteRow(id);
        return new ModelAndView("redirect:user_doctor_list");
    }

    @RequestMapping("user_doctor_edit")
    public ModelAndView editDoctor(@RequestParam int id, @ModelAttribute Doctor doctor) {
        Doctor doctorObject = doctorService.getRowById(id);
        return new ModelAndView("user_doctor_edit", "doctorObject", doctorObject);
    }

    @RequestMapping("user_doctor_update")
    public ModelAndView updateDoctor(@ModelAttribute Doctor doctor) {
        doctorService.updateRow(doctor);
        return new ModelAndView("redirect:user_doctor_list");
    }

}
