package com.flydean;

/**
 * @author wayne
 * @version VolatileUsage,  2020/2/28 8:30 上午
 */
public class VolatileWithoutUsage {
    private  int count = 0;

    public void incrementCount() {
        count++;
    }
    public int getCount() {
        return count;
    }
}
