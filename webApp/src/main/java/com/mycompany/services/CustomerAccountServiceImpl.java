package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mycompany.dao.CustomerAccountDao;
import com.mycompany.domain.CustomerAccount;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan("com.mycompany.services") // No need to include component-scan in xml
@Service("customerAccountService")
public class CustomerAccountServiceImpl implements CustomerAccountService{
	
	@Autowired
	CustomerAccountDao customerAccountDao;

        @Override
	public int insertRow(CustomerAccount customerAccount) {
		return customerAccountDao.insertRow(customerAccount);
	}

        @Override
	public List<Object[]> getList() {
		return customerAccountDao.getList();
	}

        @Override
	public CustomerAccount getRowById(int id) {
		return customerAccountDao.getRowById(id);
	}

        @Override
	public int updateRow(CustomerAccount customerAccount) {
		return customerAccountDao.updateRow(customerAccount);
	}

        @Override
	public int deleteRow(int id) {
		return customerAccountDao.deleteRow(id);
	}

}
