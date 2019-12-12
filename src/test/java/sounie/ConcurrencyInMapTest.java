package sounie;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ConcurrencyInMapTest {
    @Test
    public void shouldHandleSingleThread() {
        ConcurrencyInMap wordMap = new ConcurrencyInMap();

        for (int i = 0; i < 1000; i++) {
            wordMap.addWord("foo");
        }

        int result = wordMap.getCountForWord("foo");

        assertEquals(1000, result);
    }

    @Test
    public void shouldHandleTenThreads() throws InterruptedException {
        ConcurrencyInMap wordMap = new ConcurrencyInMap();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                wordMap.addWord("foo");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.awaitTermination(2, TimeUnit.SECONDS);
        int result = wordMap.getCountForWord("foo");

        assertEquals(1000, result);
    }
}