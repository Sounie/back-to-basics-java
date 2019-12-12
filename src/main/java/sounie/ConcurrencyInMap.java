package sounie;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Practice updating value in a map in a thread safe way, minimising blocking
public class ConcurrencyInMap {
    private final ConcurrentMap<String, Integer> wordCounts;

    public ConcurrencyInMap() {
        this.wordCounts = new ConcurrentHashMap<>(500);
    }

    public void addWord(String word) {
        wordCounts.compute(word, (key, value) -> value == null ? 1 : value + 1);
    }

    public int getCountForWord(String word) {
        return wordCounts.getOrDefault(word, 0);
    }
}
