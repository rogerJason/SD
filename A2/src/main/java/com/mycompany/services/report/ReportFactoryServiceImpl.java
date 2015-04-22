/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services.report;

import com.mycompany.dao.report.ReportDao;
import com.mycompany.dao.report.TXTReport;
import com.mycompany.dao.report.XMLReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cipri
 */
@Configuration
@ComponentScan("com.mycompany.services.report") // No need to include component-scan in xml
@Service("reportFactoryService")
public class ReportFactoryServiceImpl implements ReportFactoryService{
    
    @Autowired
    ReportDao reportDao;

    //use getReport method to get object of type report 
    @Override
    public ReportDao getReport(String reportType) {
        
        if (reportType == null) {
            return null;
        }
        if (reportType.equalsIgnoreCase("TXT")) {
            return new TXTReport();

        } else if (reportType.equalsIgnoreCase("XML")) {
            return new XMLReport();
        }
        return null;
    }

}
