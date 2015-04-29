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

import com.cb.domain.Consultation;
import com.cb.domain.Doctor;
import java.sql.Timestamp;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan("com.cb.dao") // No need to include component-scan in xml
@Repository("consultationDao")
public class ConsultationDaoImpl implements ConsultationDao {

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
    /*
    public List<Doctor> checkDoctor(Timestamp fromDate, Timestamp toDate) {
        Session session = sessionFactory.openSession();

         //Query query = session.createQuery("from Doctor d JOIN d.consultation c "
        //       + "WHERE d.id NOT IN (SELECT c.doctorId WHERE c.fromDate = :from AND c.toDate = :to )");
        
        @SuppressWarnings("unchecked")
         Query query = session.createQuery("from Consultation ca JOIN ca.doctor d "
                + "WHERE d.id NOT IN (SELECT ca.doctorId WHERE ca.fromDate = :from AND ca.toDate = :to )");
        query.setParameter("from", fromDate);
        query.setParameter("to", toDate);
  
        List<Object[]> joinedList = query.list();
        //List<Doctor> doctorList = query.list();
        List doctorList = null;
        Doctor[] doc = (Doctor[]) joinedList.get(1);
        doctorList.add(doc[0]);
        
        
        session.close();
        return doctorList;
    }
    */
    @Override
    public List<Doctor> checkDoctor(Timestamp fromDate, Timestamp toDate) {
        Session session = sessionFactory.openSession();

        @SuppressWarnings("unchecked")
        String sql = "SELECT * FROM doctor "
                + "JOIN consultation ON doctor = doctor_id "
                + "WHERE doctor_id NOT IN "
                + "(SELECT doctor FROM consultation WHERE from_date <= :from AND to_date >= :to)";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Doctor.class);
        query.setParameter("from", fromDate);
        query.setParameter("to", toDate);
        List<Doctor> doctorList = query.list();

        session.close();
        return doctorList;
    }
}
