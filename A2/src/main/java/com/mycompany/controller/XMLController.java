/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Cipri
 */
@Controller
@RequestMapping("/coffee")
public class XMLController {

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public @ResponseBody
    Coffee getCoffeeInXML(@PathVariable String name) {

        Coffee coffee = new Coffee(name, 100);

        return coffee;

    }

}
