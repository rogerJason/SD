package com.cb.controllers;

import com.cb.domain.Patient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cb.domain.Consultation;
import com.cb.services.ConsultationService;

@Controller
public class ConsultationController {
	
	@Autowired
	ConsultationService consultationService;

	@RequestMapping("user_consultation_form")
	public ModelAndView getForm(@ModelAttribute Consultation consultation) {
		return new ModelAndView("user_consultation_form");
	}
	
	@RequestMapping("user_consultation_register")
	public ModelAndView registerConsultation(@ModelAttribute Consultation consultation) {
		consultationService.insertRow(consultation);
		return new ModelAndView("redirect:user_consultation_list");
	}
	
	@RequestMapping("user_consultation_list")
	public ModelAndView getList() {
		List<Object[]> consultationList = consultationService.getList();              
		return new ModelAndView("user_consultation_list","consultationList",consultationList);
	}
	
	@RequestMapping("user_consultation_delete")
	public ModelAndView deleteConsultation(@RequestParam int id) {
		consultationService.deleteRow(id);
		return new ModelAndView("redirect:user_consultation_list");
	}
	
	@RequestMapping("user_consultation_edit")
	public ModelAndView editConsultation(@RequestParam int id,@ModelAttribute Consultation consultation) {
		Consultation consultationObject = consultationService.getRowById(id);
		return new ModelAndView("user_consultation_edit", "consultationObject", consultationObject);
	}
	
	@RequestMapping("user_consultation_update")
	public ModelAndView updateConsultation(@ModelAttribute Consultation consultation) {
		consultationService.updateRow(consultation);
		return new ModelAndView("redirect:user_consultation_list");
	}

}
