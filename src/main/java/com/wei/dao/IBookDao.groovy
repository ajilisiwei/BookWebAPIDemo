package com.wei.dao

import com.wei.entity.Book
import org.springframework.stereotype.Repository

/**
 * Created by WEI on 2017/5/13.
 */
@Repository
interface IBookDao {
    List<Book> getBooks()
    Book getBook(int id)
}