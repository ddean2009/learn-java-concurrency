package com.flydean;

/**
 * @author wayne
 * @version VolatileTrueUsage,  2020/2/28 9:11 上午
 */
public class VolatileTrueUsage {
    private volatile int count = 0;

    public void setCount(int number) {
        count=number;
    }
    public int getCount() {
        return count;
    }
}
