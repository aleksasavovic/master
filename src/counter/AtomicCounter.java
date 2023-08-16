package counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() throws InterruptedException {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}
