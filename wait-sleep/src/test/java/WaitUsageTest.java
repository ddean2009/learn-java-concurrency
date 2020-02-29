import com.flydean.WaitNotifyUsage;
import com.flydean.WaitUsage;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wayne
 * @version WaitUsageTest,  2020/2/29 9:18 上午
 */
public class WaitUsageTest {

    @Test
    public void testWaitUsage() throws InterruptedException {
        WaitUsage.WaitExample();
    }

    @Test
    public void testWaitNotifyUsage() throws InterruptedException{
        WaitNotifyUsage waitNotifyUsage=new WaitNotifyUsage();

        ExecutorService executorService=Executors.newFixedThreadPool(4);
        executorService.submit(()-> {
            try {
                waitNotifyUsage.produceMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(()-> {
            try {
                waitNotifyUsage.consumeMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(50000);


    }
}
