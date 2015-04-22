/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.report;

import javax.xml.bind.JAXBException;

/**
 *
 * @author Cipri
 */
public interface ReportDao {
   void generate() throws JAXBException;
}
