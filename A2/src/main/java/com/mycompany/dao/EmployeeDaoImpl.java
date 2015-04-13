package com.mycompany.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mycompany.domain.Employee;
import com.mycompany.domain.Employees;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan("com.mycompany.dao") // No need to include component-scan in xml
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    private String fileName = "D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\employee.xml";

    @Override
    public void insertRow(Employee employee) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Employees employees = (Employees) jaxbUnmarshaller.unmarshal(new File(fileName));

        employee.setId(employees.getEmployees().size() + 1);
        employees.getEmployees().add(employee);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(employees, new File(fileName));
    }

    @Override
    public List<Employee> getList() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Employees employees = (Employees) jaxbUnmarshaller.unmarshal(new File(fileName));

        return employees.getEmployees();
    }

    @Override
    public Employee getRowById(int id) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Employees employees = (Employees) jaxbUnmarshaller.unmarshal(new File(fileName));

        Employee employee = new Employee();
        for (Employee emp : employees.getEmployees()) {
            if (emp.getId() == id) {
                employee = emp;
            }
        }

        return employee;
    }

    @Override
    public void updateRow(Employee employee) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Employees employees = (Employees) jaxbUnmarshaller.unmarshal(new File(fileName));

        employees.getEmployees().set(employee.getId()-1, employee); 
        
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(employees, new File(fileName));
    }

    @Override
    public void deleteRow(int id) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Employees employees = (Employees) jaxbUnmarshaller.unmarshal(new File(fileName));

        employees.getEmployees().remove(id-1);

        for (int i=0; i < employees.getEmployees().size(); i++) {
            Employee emp = employees.getEmployees().get(i);
            emp.setId(i+1);
            employees.getEmployees().set(i, emp);
        }

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(employees, new File(fileName));
    }

}
