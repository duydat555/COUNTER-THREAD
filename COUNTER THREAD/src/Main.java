public class Main {
    public static void main(String[] args) {
        Counter counter= new Counter();
        int numThreads=6;
        int incrementsPerThread=5;
        IncrementThread[] threads = new IncrementThread[numThreads];
        for (int i=0; i<numThreads; i++) {
            threads[i] = new IncrementThread(counter, incrementsPerThread);
            threads[i].start();

        }
        for(IncrementThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}