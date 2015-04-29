package com.cb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cb.dao.ConsultationDao;
import com.cb.domain.Consultation;
import com.cb.domain.Doctor;
import java.sql.Timestamp;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan("com.cb.services") // No need to include component-scan in xml
@Service("consultationService")
public class ConsultationServiceImpl implements ConsultationService{
	
	@Autowired
	ConsultationDao consultationDao;

        @Override
	public int insertRow(Consultation consultation) {
		return consultationDao.insertRow(consultation);
	}

        @Override
	public List<Object[]> getList() {
		return consultationDao.getList();
	}

        @Override
	public Consultation getRowById(int id) {
		return consultationDao.getRowById(id);
	}

        @Override
	public int updateRow(Consultation consultation) {
		return consultationDao.updateRow(consultation);
	}

        @Override
	public int deleteRow(int id) {
		return consultationDao.deleteRow(id);
	}
        
        @Override
        public List<Doctor> checkDoctor(Timestamp fromDate, Timestamp toDate) {
            return consultationDao.checkDoctor(fromDate, toDate);
        }

}
