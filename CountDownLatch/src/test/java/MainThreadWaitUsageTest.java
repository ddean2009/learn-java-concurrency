import com.flydean.MainThreadWaitUsage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author wayne
 * @version CountDownLatchTest,  2020/3/10 11:55 下午
 */

@Slf4j
public class MainThreadWaitUsageTest {


    @Test
    public void testCountDownLatch()
            throws InterruptedException {

        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(5);
        List<Thread> workers = Stream
                .generate(() -> new Thread(new MainThreadWaitUsage(outputScraper, countDownLatch)))
                .limit(5)
                .collect(toList());

        workers.forEach(Thread::start);
        countDownLatch.await();
        outputScraper.add("Latch released");
        log.info(outputScraper.toString());

    }
}
