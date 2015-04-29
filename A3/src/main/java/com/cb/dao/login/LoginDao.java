package com.cb.dao.login;

import com.cb.domain.login.Users;
import java.util.List;



public interface LoginDao {
	Users findByUserName(String username);
        List<Object[]> getList();
}
