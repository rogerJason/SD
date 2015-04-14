package com.mycompany.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mycompany.domain.Book;
import com.mycompany.domain.Books;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan("com.mycompany.dao") // No need to include component-scan in xml
@Repository("bookDao")
public class BookDaoImpl implements BookDao {

    private String fileName = "D:\\GitHub\\SD\\A2\\src\\main\\webapp\\resources\\db\\book.xml";

    @Override
    public void insertRow(Book book) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Books books = (Books) jaxbUnmarshaller.unmarshal(new File(fileName));

        book.setId(books.getBooks().size() + 1);
        books.getBooks().add(book);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(books, new File(fileName));
    }

    @Override
    public List<Book> getList() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Books books = (Books) jaxbUnmarshaller.unmarshal(new File(fileName));

        return books.getBooks();
    }

    @Override
    public Book getRowById(int id) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Books books = (Books) jaxbUnmarshaller.unmarshal(new File(fileName));

        Book book = new Book();
        for (Book bk : books.getBooks()) {
            if (bk.getId() == id) {
                book = bk;
            }
        }

        return book;
    }

    @Override
    public void updateRow(Book book) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Books books = (Books) jaxbUnmarshaller.unmarshal(new File(fileName));

        books.getBooks().set(book.getId()-1, book); 
        
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(books, new File(fileName));
    }

    @Override
    public void deleteRow(int id) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Books books = (Books) jaxbUnmarshaller.unmarshal(new File(fileName));

        books.getBooks().remove(id-1);

        for (int i=0; i < books.getBooks().size(); i++) {
            Book emp = books.getBooks().get(i);
            emp.setId(i+1);
            books.getBooks().set(i, emp);
        }

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(books, new File(fileName));
    }

}
