package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.dao.DataDao;
import com.mycompany.domain.Client;

public class DataServiceImpl implements DataService {
	
	@Autowired
	DataDao dataDao;

	@Override
	public int insertRow(Client user) {
		return dataDao.insertRow(user);
	}

	@Override
	public List<Client> getList() {
		return dataDao.getList();
	}

	@Override
	public Client getRowById(int id) {
		return dataDao.getRowById(id);
	}

	@Override
	public int updateRow(Client user) {
		return dataDao.updateRow(user);
	}

	@Override
	public int deleteRow(int id) {
		return dataDao.deleteRow(id);
	}

}
