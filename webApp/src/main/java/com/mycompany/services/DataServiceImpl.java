package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.dao.DataDao;
import com.mycompany.domain.User;

public class DataServiceImpl implements DataService {
	
	@Autowired
	DataDao dataDao;

	@Override
	public int insertRow(User user) {
		return dataDao.insertRow(user);
	}

	@Override
	public List<User> getList() {
		return dataDao.getList();
	}

	@Override
	public User getRowById(int id) {
		return dataDao.getRowById(id);
	}

	@Override
	public int updateRow(User user) {
		return dataDao.updateRow(user);
	}

	@Override
	public int deleteRow(int id) {
		return dataDao.deleteRow(id);
	}

}
