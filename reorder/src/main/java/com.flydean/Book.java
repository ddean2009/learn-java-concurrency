package com.flydean;

/**
 * @author wayne
 * @version ResouceFactory,  2020/3/29 7:17 下午
 */
public class Book {

    private static Book book;

    public static Book getBook(){
        if(book==null){
            book = new Book();
        }
        return book;
    }
}
