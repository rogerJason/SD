package com.mycompany.services;

import java.util.List;

import com.mycompany.domain.User;

public interface DataService {
	public int insertRow(User user);

	public List<User> getList();

	public User getRowById(int id);

	public int updateRow(User user);

	public int deleteRow(int id);

}
