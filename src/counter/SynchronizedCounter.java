package counter;

public class SynchronizedCounter {
    private int counter = 0;

    public synchronized void increment() throws InterruptedException {
        counter++;
    }
    public int getCounter(){
        return counter;
    }
}
