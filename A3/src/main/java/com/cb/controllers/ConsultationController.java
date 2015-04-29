package com.cb.controllers;

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

	@RequestMapping("user/consultation/form")
	public ModelAndView getForm(@ModelAttribute Consultation consultation) {
		return new ModelAndView("user/consultation/form");
	}
	
	@RequestMapping("user/consultation/register")
	public ModelAndView registerConsultation(@ModelAttribute Consultation consultation) {
		consultationService.insertRow(consultation);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("user/consultation/list")
	public ModelAndView getList() {
		List<Object[]> consultationList = consultationService.getList();              
		return new ModelAndView("user/consultation/list","consultationList",consultationList);
	}
        
        @RequestMapping("doctor/list")
	public ModelAndView getDetails() {
		List<Object[]> consultationList = consultationService.getList();              
		return new ModelAndView("doctor/list","consultationList",consultationList);
	}
	
	@RequestMapping("user/consultation/delete")
	public ModelAndView deleteConsultation(@RequestParam int id) {
		consultationService.deleteRow(id);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("user/consultation/edit")
	public ModelAndView editConsultation(@RequestParam int id,@ModelAttribute Consultation consultation) {
		Consultation consultationObject = consultationService.getRowById(id);
		return new ModelAndView("user/consultation/edit", "consultationObject", consultationObject);
	}
        
        @RequestMapping("doctor/edit")
	public ModelAndView editDetails(@RequestParam int id,@ModelAttribute Consultation consultation) {
		Consultation consultationObject = consultationService.getRowById(id);
		return new ModelAndView("doctor/edit", "consultationObject", consultationObject);
	}
        
        @RequestMapping("doctor/update")
	public ModelAndView updateDetails(@ModelAttribute Consultation consultation) {
		consultationService.updateRow(consultation);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping("user/consultation/update")
	public ModelAndView updateConsultation(@ModelAttribute Consultation consultation) {
		consultationService.updateRow(consultation);
		return new ModelAndView("redirect:list");
	}

}
