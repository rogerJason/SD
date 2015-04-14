/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.domain.Employee;
import com.mycompany.services.EmployeeService;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Cipri
 */
@Controller
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("admin_employee_form")
    public ModelAndView getForm(@ModelAttribute Employee employee) {
        return new ModelAndView("admin_employee_form");
    }

    @RequestMapping("admin_employee_register")
    public ModelAndView registerUser(@ModelAttribute Employee employee) throws JAXBException {
        employeeService.insertRow(employee);
        return new ModelAndView("redirect:admin_employee_list");
    }

    @RequestMapping("admin_employee_list")
    public ModelAndView getList() throws JAXBException {
        List employeeList = employeeService.getList();
        return new ModelAndView("admin_employee_list", "employeeList", employeeList);
    }

    @RequestMapping("admin_employee_delete")
    public ModelAndView deleteClient(@RequestParam int id) throws JAXBException{
        employeeService.deleteRow(id);
        return new ModelAndView("redirect:admin_employee_list");
    }

    @RequestMapping("admin_employee_edit")
    public ModelAndView editClient(@RequestParam int id, @ModelAttribute Employee employee) throws JAXBException {
        Employee employeeObject = employeeService.getRowById(id);
        return new ModelAndView("admin_employee_edit", "employeeObject", employeeObject);
    }

    @RequestMapping("admin_employee_update")
    public ModelAndView updateClient(@ModelAttribute Employee employee) throws JAXBException {
        employeeService.updateRow(employee);
        return new ModelAndView("redirect:admin_employee_list");
    }

}
