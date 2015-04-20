/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.domain.Book;
import com.mycompany.services.BookService;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Cipri
 */
@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("admin_book_form")
    public ModelAndView getForm(@ModelAttribute Book book) {
        return new ModelAndView("admin_book_form");
    }

    @RequestMapping("admin_book_register")
    public ModelAndView registerBook(@ModelAttribute Book book) throws JAXBException {
        bookService.insertRow(book);
        return new ModelAndView("redirect:admin_book_list");
    }

    @RequestMapping("admin_book_list")
    public ModelAndView getList() throws JAXBException {
        List bookList = bookService.getList();
        return new ModelAndView("admin_book_list", "bookList", bookList);
    }
    
    @RequestMapping("user_books")
    public ModelAndView getBookList() throws JAXBException {
        List bookList = bookService.getList();
        return new ModelAndView("user_books", "bookList", bookList);
    }

    @RequestMapping("admin_book_delete")
    public ModelAndView deleteBook(@RequestParam int id) throws JAXBException{
        bookService.deleteRow(id);
        return new ModelAndView("redirect:admin_book_list");
    }

    @RequestMapping("admin_book_edit")
    public ModelAndView editBook(@RequestParam int id, @ModelAttribute Book book) throws JAXBException {
        Book bookObject = bookService.getRowById(id);
        return new ModelAndView("admin_book_edit", "bookObject", bookObject);
    }

    @RequestMapping("admin_book_update")
    public ModelAndView updateBook(@ModelAttribute Book book) throws JAXBException {
        bookService.updateRow(book);
        return new ModelAndView("redirect:admin_book_list");
    }
    
    @RequestMapping(value = "user_search", method = GET)
    public ModelAndView searchBy(@RequestParam(required = false) String searchString) throws JAXBException{
        List bookList = bookService.searchBy(searchString);
        return new ModelAndView("user_search", "bookList", bookList);
    }
  
}
