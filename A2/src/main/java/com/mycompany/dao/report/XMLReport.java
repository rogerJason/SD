/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.report;

import com.mycompany.domain.Book;
import com.mycompany.domain.Books;
import java.io.File;
import java.util.Iterator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cipri
 */
@Configuration
@ComponentScan("com.mycompany.dao.report") // No need to include component-scan in xml
@Repository("reportDao")
public class XMLReport implements ReportDao {

    private String fileName = "D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\book.xml";
    private String fileName2 = "D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\report.xml";

    @Override
    public void generate() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Books books = (Books) jaxbUnmarshaller.unmarshal(new File(fileName));

        for (Iterator<Book> iterator = books.getBooks().iterator(); iterator.hasNext();) {
            Book book = iterator.next();
            if (book.getQuantity() != 0) {
                // Remove the current element from the iterator and the list.
                iterator.remove();
            }
        }

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(books, new File(fileName2));

    }

}
