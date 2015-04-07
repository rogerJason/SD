package com.mycompany.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mycompany.domain.Client;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan("com.mycompany.dao") // No need to include component-scan in xml
@Repository("dataDao")
public class DataDaoImpl implements DataDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public int insertRow(Client user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
        Serializable id = session.getIdentifier(user);
        session.close();
        return (Integer) id;
    }

    @Override
    public List<Client> getList() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Client> userList = session.createQuery("from Client")
                .list();
        session.close();
        return userList;
    }

    @Override
    public Client getRowById(int id) {
        Session session = sessionFactory.openSession();
        Client user = (Client) session.load(Client.class, id);
        return user;
    }

    @Override
    public int updateRow(Client user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
        Serializable id = session.getIdentifier(user);
        session.close();
        return (Integer) id;
    }

    @Override
    public int deleteRow(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Client user = (Client) session.load(Client.class, id);
        session.delete(user);
        tx.commit();
        Serializable ids = session.getIdentifier(user);
        session.close();
        return (Integer) ids;
    }

}
