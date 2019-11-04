package sounie;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class LazyInitializationTest {

    @Test
    public void multiThread() throws Exception {
        LazyInitialization lazyInitialization = new LazyInitialization();

        ExecutorService service = Executors.newFixedThreadPool(40);

        for (int i = 0; i < 200; i++) {
            service.submit(() ->
            {
                for (int j = 0; j < 500000; j++) lazyInitialization.doSomethingLazily();
            });
        }

        service.awaitTermination(3, TimeUnit.SECONDS);

        long result = lazyInitialization.getValue();

        assertEquals(100000000L, result);
    }
}