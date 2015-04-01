package com.mycompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.domain.Account;
import com.mycompany.services.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@RequestMapping("account_form")
	public ModelAndView getForm(@ModelAttribute Account account) {
		return new ModelAndView("account_form");
	}
	
	@RequestMapping("account_register")
	public ModelAndView registerAccount(@ModelAttribute Account account) {
		accountService.insertRow(account);
		return new ModelAndView("redirect:account_list");
	}
	
	@RequestMapping("account_list")
	public ModelAndView getList() {
		List accountList = accountService.getList();
		return new ModelAndView("account_list","accountList",accountList);
	}
	
	@RequestMapping("account_delete")
	public ModelAndView deleteAccount(@RequestParam int id) {
		accountService.deleteRow(id);
		return new ModelAndView("redirect:account_list");
	}
	
	@RequestMapping("account_edit")
	public ModelAndView editAccount(@RequestParam int id,@ModelAttribute Account account) {
		Account accountObject = accountService.getRowById(id);
		return new ModelAndView("account_edit", "accountObject", accountObject);
	}
	
	@RequestMapping("account_update")
	public ModelAndView updateAccount(@ModelAttribute Account account) {
		accountService.updateRow(account);
		return new ModelAndView("redirect:account_list");
	}

}
