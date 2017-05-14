package com.wei.service

import com.wei.common.MsgBody
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

    MsgBody msgBody=new MsgBody()

    List<Book> getBooks(){
        this.bookDao.getBooks()
    }

    Book getBook(int id){
        this.bookDao.getBook(id)
    }

    MsgBody addBook(Book book){
        if (this.bookDao.addBook(book)>=1){
            this.msgBody.result="true"
        }else {
            this.msgBody.result="false"
        }
        this.msgBody
    }
}
