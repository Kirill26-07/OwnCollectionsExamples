/**
 * Benchmark для тестирования производительности коллекций
 */

package com.kirill.benchmark;

import com.kirill.collectionTypes.ArrayCollection;
import org.openjdk.jmh.annotations.Benchmark;
import java.util.Collection;

public class CollectionBenchmarkTest {

    private static final int ELEMENT_AMOUNT = 10_000;
    private static Collection<Integer> testCollection = new ArrayCollection<>();

    @Benchmark
    public void testAddMethod(){

        for(int i = 0; i < ELEMENT_AMOUNT; i++){
            testCollection.add(i);
        }
    }

    @Benchmark
    public void testRemoveMethodFromEnd(){

        Integer[] testArray = new Integer[ELEMENT_AMOUNT];

        for(int i = 0; i < ELEMENT_AMOUNT; i++){
            testArray[i] = i;
        }

        testCollection = new ArrayCollection<>(testArray);

        for(int i = ELEMENT_AMOUNT; i >= 0; i--){
            testCollection.remove(i);
        }
    }

    @Benchmark
    public void testRemoveMethodFromStart() {

        Integer[] testArray = new Integer[ELEMENT_AMOUNT];

        for (int i = 0; i < ELEMENT_AMOUNT; i++) {
            testArray[i] = i;
        }

        testCollection = new ArrayCollection<>(testArray);

        for (int i = 0; i < ELEMENT_AMOUNT; i++) {
            testCollection.remove(i);
        }
    }
}