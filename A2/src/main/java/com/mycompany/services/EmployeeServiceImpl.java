package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mycompany.dao.EmployeeDao;
import com.mycompany.domain.Employee;
import javax.xml.bind.JAXBException;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan("com.mycompany.services") // No need to include component-scan in xml
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertRow(Employee employee) throws JAXBException {
		employeeDao.insertRow(employee);
	}

	@Override
	public List<Employee> getList() throws JAXBException {
		return employeeDao.getList();
	}

	@Override
	public Employee getRowById(int id) {
		return employeeDao.getRowById(id);
	}

	@Override
	public int updateRow(Employee employee) {
		return employeeDao.updateRow(employee);
	}

	@Override
	public int deleteRow(int id) {
		return employeeDao.deleteRow(id);
	}

}
