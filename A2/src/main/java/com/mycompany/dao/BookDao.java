package com.mycompany.dao;

import java.util.List;

import com.mycompany.domain.Book;
import javax.xml.bind.JAXBException;

public interface BookDao {

    public void insertRow(Book book) throws JAXBException;

    public List<Book> getList() throws JAXBException;

    public Book getRowById(int id) throws JAXBException;

    public void updateRow(Book book) throws JAXBException;

    public void deleteRow(int id) throws JAXBException;
    
    public List<Book> searchBy(String searchedWord) throws JAXBException;

}
