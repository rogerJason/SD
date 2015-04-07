package com.mycompany.dao;

import java.util.List;

import com.mycompany.domain.CustomerAccount;

public interface CustomerAccountDao {
	public int insertRow(CustomerAccount customerAccount);

	public List<CustomerAccount> getList();

	public CustomerAccount getRowById(int id);

	public int updateRow(CustomerAccount customerAccount);

	public int deleteRow(int id);

}
