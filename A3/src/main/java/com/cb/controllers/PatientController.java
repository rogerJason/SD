package com.cb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cb.domain.Patient;
import com.cb.services.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	PatientService patientService;

	@RequestMapping("user/patient/form")
	public ModelAndView getForm(@ModelAttribute Patient patient) {
		return new ModelAndView("user/patient/form");
	}
	
	@RequestMapping("user/patient/register")
	public ModelAndView registerUser(@ModelAttribute Patient patient) {
		patientService.insertRow(patient);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("user/patient/list")
	public ModelAndView getList() {
		List patientList = patientService.getList();
		return new ModelAndView("user/patient/list","patientList",patientList);
	}
	
	@RequestMapping("user/patient/delete")
	public ModelAndView deleteClient(@RequestParam int id) {
		patientService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("user/patient/edit")
	public ModelAndView editClient(@RequestParam int id,@ModelAttribute Patient patient) {
		Patient patientObject = patientService.getRowById(id);
		return new ModelAndView("user/patient/edit", "patientObject", patientObject);
	}
	
	@RequestMapping("user/patient/update")
	public ModelAndView updateClient(@ModelAttribute Patient patient) {
		patientService.updateRow(patient);
		return new ModelAndView("redirect:list");
	}

}
