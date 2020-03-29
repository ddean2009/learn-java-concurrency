package com.flydean;

/**
 * @author wayne
 * @version BookStatic,  2020/3/29 7:51 下午
 */
public class BookStatic {
    private static BookStatic bookStatic= new BookStatic();

    public static BookStatic getBookStatic(){
        return bookStatic;
    }
}
