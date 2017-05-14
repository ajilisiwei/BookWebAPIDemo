package com.wei.controller

import com.wei.common.MsgBody
import com.wei.entity.Book
import com.wei.service.BookService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import javax.annotation.Resource

/**
 * Created by WEI on 2017/5/13.
 */
@RestController
class BookController {
    @Resource
    BookService service

    @RequestMapping(value='/books',method = RequestMethod.GET)
    List<Book> getBooks(){
        service.getBooks()
    }

    @RequestMapping(value='/book/{id}',method = RequestMethod.GET)
    Book getBook(@PathVariable(name='id') int id){
        service.getBook(id)
    }

    @RequestMapping(value='/book',method=RequestMethod.POST)
    MsgBody insertBook(Book book){
        service.addBook(book)
    }
}
