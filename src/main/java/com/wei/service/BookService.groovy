package com.wei.service

import com.wei.dao.IBookDao
import com.wei.entity.Book
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * Created by WEI on 2017/5/13.
 */
@Service
class BookService {

    @Resource
    IBookDao bookDao

    List<Book> getBooks(){
        this.bookDao.getBooks()
    }

    Book getBook(int id){
        this.bookDao.getBook(id)
    }
}
