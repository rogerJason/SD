/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.controllers;

import com.cb.services.login.LoginServiceImpl;
import java.security.Principal;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cb.util.Util;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Cipri
 */
@Controller
public class WebSocketsController {
    
    @Autowired
    LoginServiceImpl loginService;

    private static final Logger LOG = LoggerFactory
            .getLogger(WebSocketsController.class);

    /**
     * To handle the regular request to the application context. e.g.
     * http://localhost:8080/learn-websockets-1
     *
     * @param model
     * @param locale
     * @return
     */
    @RequestMapping("/home")
    public String handleIndexPage(Model model, Locale locale) {
        LOG.info("Request for default / url processed at {}",
                Util.getSimpleDate());
        return "home";
    }

    /**
     * Used for redirecting the login page based on User Roles
     * @return 
     */
    @RequestMapping(value = "/welcome")
    protected View welcome() {

        Set<String> roles = AuthorityUtils
                .authorityListToSet(SecurityContextHolder.getContext()
                        .getAuthentication().getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            return new RedirectView("admin/list");
        }
        if (roles.contains("ROLE_USER")) {
            return new RedirectView("user/patient/list");
        }
        if (roles.contains("ROLE_DOC")) {
            return new RedirectView("doctor/list");
        }
        return new RedirectView("home");
    }

    /**
     * Method is executed when there is a call to the <code>/logoutPage</code>
     * url.
     *
     * @return
     */
    @RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
    public String logoutPage() {
        LOG.info("Request for /logoutPage url processed at {}",
                Util.getSimpleDate());
        return "logoutPage";
    }

    @RequestMapping("/403")
    public ModelAndView getAccessDenied() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String username = "";
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            username = userDetail.getUsername();
        }

        return new ModelAndView("403", "username", username);
    }

    /**
     * Method gets executed when there are requests to the
     * <code>/secured/basicWebsockets</code> url. This url is called after a
     * successful login.
     *
     * @param model
     * @param principal
     * @param locale
     * @return
     */
    @RequestMapping("/secured/basicWebsockets")
    public String basicWebsocketsPage(Model model, Principal principal,
            Locale locale) {

        // Get a simple human readable date and time
        String formattedDate = Util.getSimpleDate(locale);

        // Get the logged in user's name
        String userName = principal.getName();

        // Set some sample messages to show on the landing 'basicWebsockets.jsp'
        // page.
        model.addAttribute("username", userName);
        model.addAttribute("time", formattedDate);

        LOG.info(
                "Request from user:{} for /secured/basicWebsockets url processed at time:{}",
                userName, formattedDate);

        return "secured/basicWebsockets";
    }

    @RequestMapping("admin/list")
    public ModelAndView getList() {
        List<Object[]> userAccountList = loginService.getList();
        return new ModelAndView("admin/list", "userAccountList", userAccountList);
    }

}
