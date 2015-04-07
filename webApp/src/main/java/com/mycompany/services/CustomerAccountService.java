package com.mycompany.services;

import java.util.List;

import com.mycompany.domain.CustomerAccount;

public interface CustomerAccountService {
	public int insertRow(CustomerAccount customeraccount);

	public List<Object[]> getList();

	public CustomerAccount getRowById(int id);

	public int updateRow(CustomerAccount customeraccount);

	public int deleteRow(int id);

}
