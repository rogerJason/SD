package com.mycompany.dao.login;

import com.mycompany.domain.login.UserRole;
import com.mycompany.domain.login.Users;
import java.util.Set;
import javax.xml.bind.JAXBException;

public interface LoginDao {

    Users findByUserName(String username) throws JAXBException;
    Set<UserRole> getUserRole(String username) throws JAXBException;
}
