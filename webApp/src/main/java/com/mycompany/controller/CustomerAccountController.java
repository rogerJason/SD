package com.mycompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.domain.CustomerAccount;
import com.mycompany.services.CustomerAccountService;

@Controller
public class CustomerAccountController {
	
	@Autowired
	CustomerAccountService customerAccountService;

	@RequestMapping("user_customerAccount_form")
	public ModelAndView getForm(@ModelAttribute CustomerAccount customerAccount) {
		return new ModelAndView("user_customerAccount_form");
	}
	
	@RequestMapping("user_customerAccount_register")
	public ModelAndView registerCustomerAccount(@ModelAttribute CustomerAccount customerAccount) {
		customerAccountService.insertRow(customerAccount);
		return new ModelAndView("redirect:user_customerAccount_list");
	}
	
	@RequestMapping("user_customerAccount_list")
	public ModelAndView getList() {
		List customerAccountList = customerAccountService.getList();
		return new ModelAndView("user_customerAccount_list","customerAccountList",customerAccountList);
	}
	
	@RequestMapping("user_customerAccount_delete")
	public ModelAndView deleteCustomerAccount(@RequestParam int id) {
		customerAccountService.deleteRow(id);
		return new ModelAndView("redirect:user_customerAccount_list");
	}
	
	@RequestMapping("user_customerAccount_edit")
	public ModelAndView editCustomerAccount(@RequestParam int id,@ModelAttribute CustomerAccount customerAccount) {
		CustomerAccount customerAccountObject = customerAccountService.getRowById(id);
		return new ModelAndView("user_customerAccount_edit", "customerAccountObject", customerAccountObject);
	}
	
	@RequestMapping("user_customerAccount_update")
	public ModelAndView updateCustomerAccount(@ModelAttribute CustomerAccount customerAccount) {
		customerAccountService.updateRow(customerAccount);
		return new ModelAndView("redirect:user_customerAccount_list");
	}

}
