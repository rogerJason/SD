package com.mycompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.domain.Client;
import com.mycompany.services.DataService;

@Controller
public class DataController {
	
	@Autowired
	DataService dataService;

	@RequestMapping("user_form")
	public ModelAndView getForm(@ModelAttribute Client client) {
		return new ModelAndView("user_form");
	}
	
	@RequestMapping("user_register")
	public ModelAndView registerUser(@ModelAttribute Client client) {
		dataService.insertRow(client);
		return new ModelAndView("redirect:user_list");
	}
	
	@RequestMapping("user_list")
	public ModelAndView getList() {
		List clientList = dataService.getList();
		return new ModelAndView("user_list","clientList",clientList);
	}
	
	@RequestMapping("user_delete")
	public ModelAndView deleteClient(@RequestParam int id) {
		dataService.deleteRow(id);
		return new ModelAndView("redirect:user_list");
	}
	
	@RequestMapping("user_edit")
	public ModelAndView editClient(@RequestParam int id,@ModelAttribute Client client) {
		Client clientObject = dataService.getRowById(id);
		return new ModelAndView("user_edit", "clientObject", clientObject);
	}
	
	@RequestMapping("user_update")
	public ModelAndView updateClient(@ModelAttribute Client client) {
		dataService.updateRow(client);
		return new ModelAndView("redirect:user_list");
	}

}
