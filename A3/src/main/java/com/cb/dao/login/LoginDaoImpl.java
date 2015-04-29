package com.cb.dao.login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cb.domain.login.Users;
import java.util.List;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public Users findByUserName(String username) {
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		Users user = (Users) session.load(Users.class, new String(username));
		tx.commit();
		return user;
	}
        
        @Override
	public List<Object[]> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

                List<Object[]> joinedList = session.createQuery("from UserRole ur JOIN ur.user u"
                        ).list();
		session.close();
                
		return joinedList;
	}

}
