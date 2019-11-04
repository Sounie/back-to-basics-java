package sounie;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamPractice {
    // Given a map and a collection of keys, return only the objects that match the keys

    public static void main(String[] args) {
        Map<Integer, String> theStuff = Map.of(1, "Hello", 53, "World", 45, "Pineapple");

        Collection<Integer> ids = Set.of(1, 45);

        List<String> matches = ids.stream().map(i -> theStuff.get(i))
                .collect(Collectors.toList());

        for (String s : matches) {
            System.out.println(s);
        }
    }
}
