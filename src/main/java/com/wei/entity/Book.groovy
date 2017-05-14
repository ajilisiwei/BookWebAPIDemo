package com.wei.entity

import javax.xml.bind.annotation.XmlRootElement

/**
 * Created by WEI on 2017/5/13.
 */
@XmlRootElement(name = 'book')
class Book {
    int id
    String title
    String description
    String pub_time
    String author

    Book(){
    }

    Book(int id, String title, String description, String pub_time, String author) {
        this.id = id
        this.title = title
        this.description = description
        this.pub_time = pub_time
        this.author = author
    }

}
