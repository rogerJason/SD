/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.domain.Employee;
import com.mycompany.domain.Employees;
import com.mycompany.services.EmployeeService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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

    @RequestMapping("employee")
    public ModelAndView getForm() throws JAXBException {

        //Initialize the employees list
        Employees employees = new Employees();

        employees.setEmployees(new ArrayList<Employee>());
        //Create two employees
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setFirstName("Lokesh");
        emp1.setLastName("Gupta");
        emp1.setIncome(100.0);

        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setFirstName("John");
        emp2.setLastName("MclaneCB");
        emp2.setIncome(200.0);

        //Add the employees in list
        employees.getEmployees().add(emp1);
        employees.getEmployees().add(emp2);

        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(employees, new File("D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\employee.xml"));

        return new ModelAndView("employee");
    }

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("user_employee_form")
    public ModelAndView getForm(@ModelAttribute Employee employee) {
        return new ModelAndView("user_employee_form");
    }

    @RequestMapping("user_employee_register")
    public ModelAndView registerUser(@ModelAttribute Employee employee) throws JAXBException {
        employeeService.insertRow(employee);
        return new ModelAndView("redirect:user_employee_list");
    }

    @RequestMapping("user_employee_list")
    public ModelAndView getList() throws JAXBException {
        List employeeList = employeeService.getList();
        return new ModelAndView("user_employee_list", "employeeList", employeeList);
    }

    @RequestMapping("user_employee_delete")
    public ModelAndView deleteClient(@RequestParam int id) {
        employeeService.deleteRow(id);
        return new ModelAndView("redirect:user_employee_list");
    }

    @RequestMapping("user_employee_edit")
    public ModelAndView editClient(@RequestParam int id, @ModelAttribute Employee employee) {
        Employee employeeObject = employeeService.getRowById(id);
        return new ModelAndView("user_employee_edit", "employeeObject", employeeObject);
    }

    @RequestMapping("user_employee_update")
    public ModelAndView updateClient(@ModelAttribute Employee employee) {
        employeeService.updateRow(employee);
        return new ModelAndView("redirect:user_employee_list");
    }

}
