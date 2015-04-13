package com.mycompany.dao;

import java.util.List;

import com.mycompany.domain.Employee;
import javax.xml.bind.JAXBException;

public interface EmployeeDao {

    public void insertRow(Employee employee) throws JAXBException;

    public List<Employee> getList() throws JAXBException;

    public Employee getRowById(int id);

    public int updateRow(Employee employee);

    public int deleteRow(int id);

}
