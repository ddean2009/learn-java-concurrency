package com.flydean;

import java.util.HashMap;

/**
 * @author wayne
 * @version FinalSafe,  2020/3/29 9:21 下午
 */
public class FinalSafe {
    private final HashMap<String,String> hashMap;

    public FinalSafe(){
        hashMap= new HashMap<>();
        hashMap.put("key1","value1");
    }
}
