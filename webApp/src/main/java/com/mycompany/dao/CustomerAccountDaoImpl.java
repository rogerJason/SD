package com.mycompany.dao;

import com.mycompany.domain.Client;
import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mycompany.domain.CustomerAccount;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan("com.mycompany.dao") // No need to include component-scan in xml
@Repository("customerAccountDao")
public class CustomerAccountDaoImpl implements CustomerAccountDao{

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
        @Override
	public int insertRow(CustomerAccount customerAccount) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customerAccount);
		tx.commit();
		Serializable id = session.getIdentifier(customerAccount);
		session.close();
		return (Integer) id;
	}

        @Override
	public List<CustomerAccount> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		//List<CustomerAccount> customerAccountList = session.createQuery("from CustomerAccount").list();
                
                List<Object[]> joinedList = session.createQuery("from CustomerAccount ca JOIN ca.client c "
                        + "WHERE ca.idCustomer = c.id").list();
		session.close();
                
                List<CustomerAccount> customerAccountList = new ArrayList<>();
                
                for (Object[] result : joinedList) {
                CustomerAccount ca = (CustomerAccount) result[0];
                Client client = (Client) result[1];
                System.out.println("\nCLIENT IS: " + client);
                
                customerAccountList.add(ca);
                }
                
		return customerAccountList;
	}

        @Override
	public CustomerAccount getRowById(int id) {
		Session session = sessionFactory.openSession();
		CustomerAccount customerAccount = (CustomerAccount) session.load(CustomerAccount.class, id);
		return customerAccount;
	}

        @Override
	public int updateRow(CustomerAccount customerAccount) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customerAccount);
		tx.commit();
		Serializable id = session.getIdentifier(customerAccount);
		session.close();
		return (Integer) id;
	}

        @Override
	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		CustomerAccount customerAccount = (CustomerAccount) session.load(CustomerAccount.class, id);
		session.delete(customerAccount);
		tx.commit();
		Serializable ids = session.getIdentifier(customerAccount);
		session.close();
		return (Integer) ids;
	}

}
