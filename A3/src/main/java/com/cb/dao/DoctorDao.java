package com.cb.dao;

import java.util.List;

import com.cb.domain.Doctor;

public interface DoctorDao {

    public int insertRow(Doctor doctor);

    public List<Doctor> getList();

    public Doctor getRowById(int id);

    public int updateRow(Doctor doctor);

    public int deleteRow(int id);

}
