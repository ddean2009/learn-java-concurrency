package com.flydean;

/**
 * @author wayne
 * @version BookStatic,  2020/3/29 7:51 下午
 */
public class BookStaticLazy {

    private static class BookStaticHolder{
        private static BookStaticLazy bookStatic= new BookStaticLazy();
    }

    public static BookStaticLazy getBookStatic(){
        return BookStaticHolder.bookStatic;
    }
}
