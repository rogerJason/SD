package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mycompany.dao.AccountDao;
import com.mycompany.domain.Account;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan("com.mycompany.services") // No need to include component-scan in xml
@Service("accountService")
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao accountDao;

        @Override
	public int insertRow(Account account) {
		return accountDao.insertRow(account);
	}

        @Override
	public List<Account> getList() {
		return accountDao.getList();
	}

        @Override
	public Account getRowById(int id) {
		return accountDao.getRowById(id);
	}

        @Override
	public int updateRow(Account account) {
		return accountDao.updateRow(account);
	}
        
        @Override
	public void updateRows(int from, int to, int amount) {
		accountDao.updateRows(from, to, amount);
	}

        @Override
	public int deleteRow(int id) {
		return accountDao.deleteRow(id);
	}

}
