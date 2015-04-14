package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mycompany.dao.BookDao;
import com.mycompany.domain.Book;
import javax.xml.bind.JAXBException;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan("com.mycompany.services") // No need to include component-scan in xml
@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao bookDao;

	@Override
	public void insertRow(Book book) throws JAXBException {
		bookDao.insertRow(book);
	}

	@Override
	public List<Book> getList() throws JAXBException {
		return bookDao.getList();
	}

	@Override
	public Book getRowById(int id) throws JAXBException{
		return bookDao.getRowById(id);
	}

	@Override
	public void updateRow(Book book) throws JAXBException{
		bookDao.updateRow(book);
	}

	@Override
	public void deleteRow(int id) throws JAXBException{
		bookDao.deleteRow(id);
	}

}
