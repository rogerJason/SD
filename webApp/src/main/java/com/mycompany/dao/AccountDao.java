package com.mycompany.dao;

import java.util.List;

import com.mycompany.domain.Account;

public interface AccountDao {
	public int insertRow(Account account);

	public List<Account> getList();

	public Account getRowById(int id);

	public int updateRow(Account account);

	public int deleteRow(int id);

}
