package com.flydean;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wayne
 * @version ShareMapWithUserContextTest,  2020/3/2 11:11 上午
 */
public class ShareMapWithUserContextTest {

    @Test
    public void testWithMap(){
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();
        assertEquals(SharedMapWithUserContext.userContextPerUserId.size(), 2);
    }
}
