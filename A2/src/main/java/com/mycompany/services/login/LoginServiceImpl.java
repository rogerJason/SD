package com.mycompany.services.login;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.dao.login.LoginDao;
import com.mycompany.domain.login.UserRole;
import com.mycompany.domain.login.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

@Service("loginService")
public class LoginServiceImpl implements UserDetailsService {

    @Autowired
    LoginDao loginDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = new Users();
        try {
            user = loginDao.findByUserName(username);
        } catch (JAXBException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<GrantedAuthority> authorities = null;
        try {
            authorities = buildUserAuthority(loginDao.getUserRole(username));
        } catch (JAXBException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return buildUserForAuthentication(user, authorities);
    }

        // Converts com.mycompany.domain.login.Users user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(Users user,
            List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
                setAuths);

        return Result;
    }

}
