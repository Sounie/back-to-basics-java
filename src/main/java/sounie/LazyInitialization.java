package sounie;

import java.util.concurrent.atomic.AtomicLong;

public class LazyInitialization {
    private AtomicLong myThing;

    long doSomethingLazily() {
        myThing = LazyHolder.INSTANCE;

        return myThing.incrementAndGet();
    }

    long getValue() {
        return myThing != null ? myThing.get() : 0L;
    }

    // This static way of lazily initializing won't play nicely if used more than once - because it's static
    static class LazyHolder {
        static final AtomicLong INSTANCE = new AtomicLong();

        private LazyHolder() {
            // Not intended for instantiation.
        }
    }
}
