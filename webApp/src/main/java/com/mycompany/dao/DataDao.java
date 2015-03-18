package com.mycompany.dao;

import java.util.List;

import com.mycompany.domain.User;

public interface DataDao {
	public int insertRow(User user);

	public List<User> getList();

	public User getRowById(int id);

	public int updateRow(User user);

	public int deleteRow(int id);

}
