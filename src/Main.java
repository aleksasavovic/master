import counter.AtomicCounter;
import counter.SynchronizedCounter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int numberOfThreads = 8;
        CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);
        //ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        //SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        AtomicCounter synchronizedCounter = new AtomicCounter();
        Thread[] threads = new Thread[numberOfThreads];
        long startTime = System.currentTimeMillis();
        for(int i=0;i<numberOfThreads;i++){
            threads[i]=new Thread(()->{
                for(int j=0;j<1000000;j++){
                    try {
                        synchronizedCounter.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
        for(int i=0;i<numberOfThreads;i++){
            threads[i].join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(synchronizedCounter.getCounter());

    }
}
