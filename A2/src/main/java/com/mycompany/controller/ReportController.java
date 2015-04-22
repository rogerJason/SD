/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.report.ReportDao;
import com.mycompany.services.report.ReportFactoryService;
import javax.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Cipri
 */
@Controller
public class ReportController {

    @Autowired
    ReportFactoryService reportFactory;
    
    @RequestMapping("admin_report")
    public ModelAndView getReport() {
        return new ModelAndView("admin_report");
    }

    @RequestMapping("admin_report_txt")
    public ModelAndView generateTXT() throws JAXBException {
        ReportDao report = reportFactory.getReport("TXT");
        report.generate();
        return new ModelAndView("redirect:admin_report");
    }

    @RequestMapping("admin_report_xml")
    public ModelAndView generateXML() throws JAXBException {
        ReportDao report = reportFactory.getReport("XML");
        report.generate();
        return new ModelAndView("redirect:admin_report");
    }
  
}
