/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Coffee;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
        FileWriter fw = null;
        try {

            File file = new File("D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\coffee.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Coffee.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            fw = new FileWriter(file, true);
            jaxbMarshaller.marshal(coffee, fw); // instead of file, because it would overwrite it
            jaxbMarshaller.marshal(coffee, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return coffee;

    }

}
