package com.cb.dao;

import com.cb.domain.Patient;
import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cb.domain.Consultation;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan("com.cb.dao") // No need to include component-scan in xml
@Repository("consultationDao")
public class ConsultationDaoImpl implements ConsultationDao{

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
        @Override
	public int insertRow(Consultation consultation) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(consultation);
		tx.commit();
		Serializable id = session.getIdentifier(consultation);
		session.close();
		return (Integer) id;
	}

        @Override
	public List<Object[]> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

                List<Object[]> joinedList = session.createQuery("from Consultation ca JOIN ca.patient p JOIN ca.doctor d"
                        + " WHERE ca.patientId = p.id AND ca.doctorId = d.id").list();
		session.close();
                
		return joinedList;
	}

        @Override
	public Consultation getRowById(int id) {
		Session session = sessionFactory.openSession();
		Consultation consultation = (Consultation) session.load(Consultation.class, id);
		return consultation;
	}

        @Override
	public int updateRow(Consultation consultation) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(consultation);
		tx.commit();
		Serializable id = session.getIdentifier(consultation);
		session.close();
		return (Integer) id;
	}

        @Override
	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Consultation consultation = (Consultation) session.load(Consultation.class, id);
		session.delete(consultation);
		tx.commit();
		Serializable ids = session.getIdentifier(consultation);
		session.close();
		return (Integer) ids;
	}

}
