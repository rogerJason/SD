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

import com.cb.domain.Doctor;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan("com.cb.dao") // No need to include component-scan in xml
@Repository("doctorDao")
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    @Override
    public int insertRow(Doctor doctor) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(doctor);
        tx.commit();
        Serializable id = session.getIdentifier(doctor);
        session.close();
        return (Integer) id;
    }

    @Override
    public List<Doctor> getList() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Doctor> doctorList = session.createQuery("from Doctor").list();
        session.close();
        return doctorList;
    }

    @Override
    public Doctor getRowById(int id) {
        Session session = sessionFactory.openSession();
        Doctor doctor = (Doctor) session.load(Doctor.class, id);
        return doctor;
    }

    @Override
    public int updateRow(Doctor doctor) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(doctor);
        tx.commit();
        Serializable id = session.getIdentifier(doctor);
        session.close();
        return (Integer) id;
    }

    @Override
    public int deleteRow(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Doctor doctor = (Doctor) session.load(Doctor.class, id);
        session.delete(doctor);
        tx.commit();
        Serializable ids = session.getIdentifier(doctor);
        session.close();
        return (Integer) ids;
    }

}
