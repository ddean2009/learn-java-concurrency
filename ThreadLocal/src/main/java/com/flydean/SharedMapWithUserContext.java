package com.flydean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wayne
 * @version SharedMapWithUserContext,  2020/3/2 10:57 上午
 */
public class SharedMapWithUserContext implements Runnable {

    public static Map<Integer, Context> userContextPerUserId
            = new ConcurrentHashMap<>();
    private Integer userId;
    private UserRepository userRepository = new UserRepository();

    public SharedMapWithUserContext(int i) {
        this.userId=i;
    }

    @Override
    public void run() {
        String userName = userRepository.getUserNameForUserId(userId);
        userContextPerUserId.put(userId, new Context(userName));
    }
}
