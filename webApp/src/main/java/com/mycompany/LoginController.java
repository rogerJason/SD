/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Cipri
 */
@Controller
@RequestMapping("/Login")
public class LoginController {
    @RequestMapping(method = RequestMethod.POST)
	public ModelAndView processCredentials(@RequestParam("userName")String userName,@RequestParam("password")String password) {
		String message = "Invalid credentials";
		if(!userName.equals("") && !password.equals("")) {
			if(userName.equals(password)) {
				message = "Welcome " + userName + "!!";
			}
		}
		return new ModelAndView("results", "message", message);
	}
}
