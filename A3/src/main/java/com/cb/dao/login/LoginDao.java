package com.cb.dao.login;

import com.cb.domain.login.Users;



public interface LoginDao {
	Users findByUserName(String username);
}
