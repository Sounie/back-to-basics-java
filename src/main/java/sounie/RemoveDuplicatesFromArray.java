package sounie;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Remove duplicates from array of arbitrary type without using Collections API.
 */
public class RemoveDuplicatesFromArray<T> {

    public T[] removeDuplicates(T[] incoming) {
        // FIXME: Possible to use type inference, or will erasure prevent that?
        T[] result = (T[])Array.newInstance(incoming.getClass().getComponentType(), incoming.length);

        int resultSize = 0;

        for (int i = 0; i < incoming.length; i++) {
            boolean alreadySeen = false;
            int j;
            for (j = 0; j < resultSize; j++) {
                if (incoming[i].equals(result[j])) {
                    alreadySeen = true;
                    break;
                }
            }

            if (!alreadySeen) {
                result[j] = incoming[i];
                resultSize++;
            }
        }

        if (resultSize < incoming.length) {
            result = trimArray(result, resultSize);
        }

        return result;
    }

    T[] trimArray(T[] preTrim, int length) {
        T[] trimmedArray = (T[])Array.newInstance(preTrim.getClass().getComponentType(), length);
// FIXME: look into System.arraycopy();

        System.arraycopy(preTrim, 0, trimmedArray, 0, length);
//        for (int i = 0; i < length; i++) {
//            trimmedArray[i] = preTrim[i];
//        }
//
        return trimmedArray;
    }
}
