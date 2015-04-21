package com.mycompany.dao.login;

import com.mycompany.domain.login.UserRole;
import com.mycompany.domain.login.UserRoleList;
import org.springframework.stereotype.Repository;

import com.mycompany.domain.login.Users;
import com.mycompany.domain.login.UsersList;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

    private String fileName = "D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\user.xml";
    private String fileName2 = "D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\user_role.xml";

    @Override
    public Users findByUserName(String username) throws JAXBException  {
        JAXBContext jaxbContext = JAXBContext.newInstance(UsersList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        UsersList usersList = (UsersList) jaxbUnmarshaller.unmarshal(new File(fileName));

        Users user = new Users();
        for (Users usr : usersList.getUsers()) {
            if (usr.getUsername().equalsIgnoreCase(username)) {
                user = usr;
            }
        }

        return user;
    }
    
    @Override
    public Set<UserRole> getUserRole(String username) throws JAXBException {
        Set<UserRole> userRole = new HashSet<>(0);
        
        JAXBContext jaxbContext = JAXBContext.newInstance(UserRoleList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        UserRoleList userRoleList = (UserRoleList) jaxbUnmarshaller.unmarshal(new File(fileName2));

        for (UserRole usr : userRoleList.getUserRoles()) {
            if (usr.getUsername().equalsIgnoreCase(username)) {
                userRole.add(usr);
            }
        }

        return userRole;
    }

}
