package com.mycompany.dao;

import java.util.List;

import com.mycompany.domain.Client;

public interface DataDao {
	public int insertRow(Client user);

	public List<Client> getList();

	public Client getRowById(int id);

	public int updateRow(Client user);

	public int deleteRow(int id);

}
