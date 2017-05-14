package com.wei.controller

import com.wei.entity.Book
import com.wei.service.BookService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.annotation.Resource

/**
 * Created by WEI on 2017/5/13.
 */
@RestController
class BookController {
    @Resource
    BookService service

    @RequestMapping('/books')
    List<Book> getBooks(){
        service.getBooks()
    }

    @RequestMapping('/book/{id}')
    Book getBook(@PathVariable(name='id') int id){
        service.getBook(id)
    }
}
