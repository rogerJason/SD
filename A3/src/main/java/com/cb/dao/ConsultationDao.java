package com.cb.dao;

import java.util.List;

import com.cb.domain.Consultation;
import com.cb.domain.Doctor;
import java.sql.Timestamp;

public interface ConsultationDao {
	public int insertRow(Consultation consultation);

	public List<Object[]> getList();

	public Consultation getRowById(int id);

	public int updateRow(Consultation consultation);

	public int deleteRow(int id);
        
        public List<Doctor> checkDoctor(Timestamp fromDate, Timestamp toDate);

}
