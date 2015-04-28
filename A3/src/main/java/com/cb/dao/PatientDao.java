package com.cb.dao;

import java.util.List;

import com.cb.domain.Patient;

public interface PatientDao {

    public int insertRow(Patient patient);

    public List<Patient> getList();

    public Patient getRowById(int id);

    public int updateRow(Patient patient);

    public int deleteRow(int id);

}
