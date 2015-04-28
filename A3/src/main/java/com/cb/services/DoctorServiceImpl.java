package com.cb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cb.dao.DoctorDao;
import com.cb.domain.Doctor;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan("com.cb.services") // No need to include component-scan in xml
@Service("doctorService")
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	DoctorDao doctorDao;

        @Override
	public int insertRow(Doctor doctor) {
		return doctorDao.insertRow(doctor);
	}

        @Override
	public List<Doctor> getList() {
		return doctorDao.getList();
	}

        @Override
	public Doctor getRowById(int id) {
		return doctorDao.getRowById(id);
	}

        @Override
	public int updateRow(Doctor doctor) {
		return doctorDao.updateRow(doctor);
	}
        
        @Override
	public int deleteRow(int id) {
		return doctorDao.deleteRow(id);
	}

}
