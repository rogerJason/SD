package com.cb.services;

import java.util.List;

import com.cb.domain.Patient;

public interface PatientService {
	public int insertRow(Patient patient);

	public List<Patient> getList();

	public Patient getRowById(int id);

	public int updateRow(Patient patient);

	public int deleteRow(int id);

}
