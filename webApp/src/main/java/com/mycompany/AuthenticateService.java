/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author Cipri
 */
public class AuthenticateService {
    
    private HibernateTemplate hibernateTemplate;
    
    public AuthenticateService() {
	
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public boolean verifyUserNameAndPassword(String username,String password) {
		System.out.println("Inside into service class");
		boolean userStatus = false;
		try {
			@SuppressWarnings("unchecked")
			List<User> userObjs = hibernateTemplate.find("from User u where u.userName=? and u.password=?",new Object[]{username,password});
			if(userObjs.size() != 0) {
				//System.out.println("User ID : " + userObjs.get(0).getUserId() + ", User name : " + userObjs.get(0).getUserName() + ", Password : " + userObjs.get(0).getPassword());
				userStatus = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userStatus;
	}
    
}
