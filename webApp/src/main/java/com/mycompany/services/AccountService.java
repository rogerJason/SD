package com.mycompany.services;

import java.util.List;

import com.mycompany.domain.Account;

public interface AccountService {
	public int insertRow(Account account);

	public List<Account> getList();

	public Account getRowById(int id);

	public int updateRow(Account account);
        
        public void updateRows(int from, int to, int amount);

	public int deleteRow(int id);

}
