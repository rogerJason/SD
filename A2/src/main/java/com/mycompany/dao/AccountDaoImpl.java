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

import com.mycompany.domain.Account;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan("com.mycompany.dao") // No need to include component-scan in xml
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    @Override
    public int insertRow(Account account) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(account);
        tx.commit();
        Serializable id = session.getIdentifier(account);
        session.close();
        return (Integer) id;
    }

    @Override
    public List<Account> getList() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Account> accountList = session.createQuery("from Account").list();
        session.close();
        return accountList;
    }

    @Override
    public Account getRowById(int id) {
        Session session = sessionFactory.openSession();
        Account account = (Account) session.load(Account.class, id);
        return account;
    }
 
    @Override
    public int updateRow(Account account) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(account);
        tx.commit();
        Serializable id = session.getIdentifier(account);
        session.close();
        return (Integer) id;
    }
    
    @Override
    public void updateRows(int from, int to, int amount) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Account accFrom = (Account) session.load(Account.class, from);
        Account accTo = (Account) session.load(Account.class, to);

        if (accFrom.getBalance() > amount) {
            accFrom.setBalance(accFrom.getBalance() - amount);
            accTo.setBalance(accTo.getBalance() + amount);
        }
 
       
        session.saveOrUpdate(accFrom);
        session.saveOrUpdate(accTo);
        tx.commit();
        session.close();
    }

    @Override
    public int deleteRow(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Account account = (Account) session.load(Account.class, id);
        session.delete(account);
        tx.commit();
        Serializable ids = session.getIdentifier(account);
        session.close();
        return (Integer) ids;
    }

}
