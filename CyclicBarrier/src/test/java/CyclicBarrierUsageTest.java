import com.flydean.CyclicBarrierUsage;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wayne
 * @version CyclicBarrierUsageTest,  2020/3/11 10:36 上午
 */
public class CyclicBarrierUsageTest {

    @Test
    public void testCyclicBarrier(){
        List<List<Integer>> partialResults
                = Collections.synchronizedList(new ArrayList<>());
        CyclicBarrier cyclicBarrier=new CyclicBarrier(5,()->{
            String thisThreadName = Thread.currentThread().getName();

            System.out.println(
                    thisThreadName + ": Computing sum of 5 workers, having 10 results each.");
            int sum = 0;

            for (List<Integer> threadResult : partialResults) {
                System.out.print("Adding ");
                for (Integer partialResult : threadResult) {
                    System.out.print(partialResult+" ");
                    sum += partialResult;
                }
                System.out.println();
            }
            System.out.println(thisThreadName + ": Final result = " + sum);
        });

        System.out.println("Spawning 5 worker threads to compute 10 partial results each");

        for (int i = 0; i < 5; i++) {
            Thread worker = new Thread(new CyclicBarrierUsage(cyclicBarrier,partialResults));
            worker.setName("Thread " + i);
            worker.start();
        }
    }


}
