/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.report;

import com.mycompany.domain.Book;
import com.mycompany.domain.Books;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Cipri
 */
public class TXTReport implements ReportDao {
    
    private String fileName = "D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\report.txt";
    private String fileName2 = "D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\book.xml";

    @Override
    public void generate() throws JAXBException {
        
        PrintWriter writer = null;
        
        try {
            writer = new PrintWriter(fileName, "UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TXTReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TXTReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        writer.println("Books Out of Stock:");
        writer.println(" ");
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Books books = (Books) jaxbUnmarshaller.unmarshal(new File(fileName2));

        for (Iterator<Book> iterator = books.getBooks().iterator(); iterator.hasNext();) {
            Book book = iterator.next();
            if (book.getQuantity() == 0) {
                // Remove the current element from the iterator and the list.
                writer.println(book.getTitle() + " by " + book.getAuthor());
                writer.println(" ");
            }
        }      
        
        writer.close();
    }

}
