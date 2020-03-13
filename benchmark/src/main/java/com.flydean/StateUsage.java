package com.flydean;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.nio.charset.Charset;

/**
 * @author wayne
 * @version StateUsage,  2020/3/13 11:16 下午
 */
@State(Scope.Benchmark)
public class StateUsage {

    @Param({ "100", "200", "300", "500", "1000" })
    public int iterations;

    public Hasher murmur3;

    public String password = "123456";

    @Setup(Level.Invocation)
    public void setUp() {
        murmur3 = Hashing.murmur3_128().newHasher();
    }

//    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void benchMurmur3_128(StateUsage plan) {

        for (int i = plan.iterations; i > 0; i--) {
            plan.murmur3.putString(plan.password, Charset.defaultCharset());
        }

        plan.murmur3.hash();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StateUsage.class.getSimpleName())
//                .include(BenchMarkUsage.class.getSimpleName()+".*measureAll*")
                // 预热5轮
                .warmupIterations(3)
                // 度量10轮
                .measurementIterations(5)
                //代表启动多个单独的进程分别测试每个方法，我们这里指定为每个方法启动一个进程
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
