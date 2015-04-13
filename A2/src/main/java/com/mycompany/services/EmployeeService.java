package com.mycompany.services;

import java.util.List;

import com.mycompany.domain.Employee;
import javax.xml.bind.JAXBException;

public interface EmployeeService {
	public void insertRow(Employee employee) throws JAXBException;

	public List<Employee> getList() throws JAXBException;

	public Employee getRowById(int id) throws JAXBException;

	public void updateRow(Employee employee) throws JAXBException;

	public void deleteRow(int id) throws JAXBException;

}
