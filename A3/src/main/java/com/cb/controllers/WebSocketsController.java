/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.controllers;

import java.security.Principal;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cb.util.Util;

/**
 *
 * @author Cipri
 */
@Controller
public class WebSocketsController {

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
    @RequestMapping("/")
    public String handleIndexPage(Model model, Locale locale) {
        LOG.info("Request for default / url processed at {}",
                Util.getSimpleDate());
        return "loginPage";
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

    /**
     * Method is executed when there is a call to the <code>/loginPage</code>
     * url. On successful login, the user is re-directed to the
     * <code>/secured/myPage</code> url.
     *
     * @return
     */
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() {
        LOG.info("Request for /loginPage url processed at {}",
                Util.getSimpleDate());
        return "loginPage";
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

}
