package com.cb.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cb.domain.Patient;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan("com.cb.dao") // No need to include component-scan in xml
@Repository("patientDao")
public class PatientDaoImpl implements PatientDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public int insertRow(Patient patient) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(patient);
        tx.commit();
        Serializable id = session.getIdentifier(patient);
        session.close();
        return (Integer) id;
    }

    @Override
    public List<Patient> getList() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Patient> patientList = session.createQuery("from Patient")
                .list();
        session.close();
        return patientList;
    }

    @Override
    public Patient getRowById(int id) {
        Session session = sessionFactory.openSession();
        Patient patient = (Patient) session.load(Patient.class, id);
        return patient;
    }

    @Override
    public int updateRow(Patient patient) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(patient);
        tx.commit();
        Serializable id = session.getIdentifier(patient);
        session.close();
        return (Integer) id;
    }

    @Override
    public int deleteRow(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Patient patient = (Patient) session.load(Patient.class, id);
        session.delete(patient);
        tx.commit();
        Serializable ids = session.getIdentifier(patient);
        session.close();
        return (Integer) ids;
    }

}
