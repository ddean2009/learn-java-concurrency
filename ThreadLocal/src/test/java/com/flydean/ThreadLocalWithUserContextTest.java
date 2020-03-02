package com.flydean;

import org.junit.Test;

/**
 * @author wayne
 * @version ThreadLocalWithUserContextTest,  2020/3/2 11:16 上午
 */
public class ThreadLocalWithUserContextTest {

    @Test
    public void testWithThreadLocal(){
        ThreadLocalWithUserContext firstUser
                = new ThreadLocalWithUserContext(1);
        ThreadLocalWithUserContext secondUser
                = new ThreadLocalWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();
    }
}
