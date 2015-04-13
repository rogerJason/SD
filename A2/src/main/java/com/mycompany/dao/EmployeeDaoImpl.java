package com.mycompany.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mycompany.domain.Employee;
import com.mycompany.domain.Employees;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan("com.mycompany.dao") // No need to include component-scan in xml
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void insertRow(Employee employee) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Employees employees = (Employees) jaxbUnmarshaller.unmarshal(new File("D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\employee.xml"));

        employee.setId(employees.getEmployees().size() + 1);
        employees.getEmployees().add(employee);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //Marshal the employees list in file
        jaxbMarshaller.marshal(employees, new File("D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\employee.xml"));
    }

    @Override
    public List<Employee> getList() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Employees employees = (Employees) jaxbUnmarshaller.unmarshal(new File("D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\employee.xml"));

        List employeeList = employees.getEmployees();
        
        return employeeList;
    }

    @Override
    public Employee getRowById(int id) {
        Employee employee = new Employee();
        return employee;
    }

    @Override
    public int updateRow(Employee employee) {

        return (Integer) 0;
    }

    @Override
    public int deleteRow(int id) {

        return (Integer) 0;
    }

}
