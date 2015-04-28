package com.cb.dao;

import java.util.List;

import com.cb.domain.Consultation;

public interface ConsultationDao {
	public int insertRow(Consultation consultation);

	public List<Object[]> getList();

	public Consultation getRowById(int id);

	public int updateRow(Consultation consultation);

	public int deleteRow(int id);

}
