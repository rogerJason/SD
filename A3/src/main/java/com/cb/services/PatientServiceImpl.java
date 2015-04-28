package com.cb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cb.dao.PatientDao;
import com.cb.domain.Patient;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan("com.cb.services") // No need to include component-scan in xml
@Service("patientService")
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientDao patientDao;

	@Override
	public int insertRow(Patient patient) {
		return patientDao.insertRow(patient);
	}

	@Override
	public List<Patient> getList() {
		return patientDao.getList();
	}

	@Override
	public Patient getRowById(int id) {
		return patientDao.getRowById(id);
	}

	@Override
	public int updateRow(Patient patient) {
		return patientDao.updateRow(patient);
	}

	@Override
	public int deleteRow(int id) {
		return patientDao.deleteRow(id);
	}

}
