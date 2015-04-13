package com.mycompany.dao.login;

import com.mycompany.domain.login.Users;



public interface LoginDao {
	Users findByUserName(String username);
}
