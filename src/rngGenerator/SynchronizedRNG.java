package rngGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class SynchronizedRNG {
    private int seed;

    private synchronized int generateNext(){
        seed = ThreadLocalRandom.current().nextInt(seed);
        return seed;
    }

}
