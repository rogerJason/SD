package com.mycompany.services;

import java.util.List;

import com.mycompany.domain.Client;

public interface DataService {
	public int insertRow(Client user);

	public List<Client> getList();

	public Client getRowById(int id);

	public int updateRow(Client user);

	public int deleteRow(int id);

}
