package com.kirill;

import com.kirill.collectionTypes.ArrayCollection;
import org.junit.jupiter.api.*;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

class ArrayCollectionTest {

    private static final Integer TEST_VALUE_1 = 1;
    private static final Integer TEST_VALUE_2 = 2;
    private static final Integer TEST_VALUE_3 = 3;

    private static int sizeValue = 2;
    private static final int EMPTY_ARRAY_SIZE = 0;

    private static final Integer[] testIntegerArray = new Integer[]{1,2};
    private static Collection<Integer> testCollection = new ArrayCollection<>();

    private static final ArrayCollection<Integer> arrayCollection = new ArrayCollection<>();

    @BeforeEach
    void createCollection(){
        arrayCollection.add(TEST_VALUE_1);
        arrayCollection.add(TEST_VALUE_2);
    }

    @AfterEach
    void clearCollection(){
        arrayCollection.clear();
    }

    @Test
    void add() {
        assertArrayEquals(testIntegerArray, arrayCollection.getArray());
    }

    @Test
    void size() {
        assertEquals(sizeValue, arrayCollection.size());
    }

    @Test
    void isEmpty() {
        assertFalse(arrayCollection.isEmpty());
    }

    @Test
    void contains() {
        assertFalse(arrayCollection.contains(TEST_VALUE_3));
        assertTrue(arrayCollection.contains(TEST_VALUE_1));
        assertTrue(arrayCollection.contains(TEST_VALUE_2));
    }

    @Test
    void iterator() {
        Integer[] elements = new Integer[2];
        int count = 0;

        for (Integer item : arrayCollection){
            elements[count++] = item;
        }
        assertArrayEquals(testIntegerArray, elements);
    }

    @Test
    void toArray() {
        assertArrayEquals(testIntegerArray, arrayCollection.toArray());
    }


    @Test
    void remove() {
        assertTrue(arrayCollection.remove(TEST_VALUE_1));
        assertTrue(arrayCollection.remove(TEST_VALUE_2));
        assertFalse(arrayCollection.remove(TEST_VALUE_3));
    }

    @Test
    void containsAll() {
        testCollection = new ArrayCollection<>();
        testCollection.add(1);
        testCollection.add(2);
        assertTrue(arrayCollection.containsAll(testCollection));
        testCollection.add(3);
        assertFalse(arrayCollection.containsAll(testCollection));
    }

    @Test
    void addAll() {
        testCollection = new ArrayCollection<>();
        testCollection.add(3);
        testCollection.add(4);
        assertTrue(arrayCollection.addAll(testCollection));
        Integer[] newArray = new Integer[]{1,2,3,4};
        assertArrayEquals(newArray, arrayCollection.getArray());
    }

    @Test
    void removeAll() {
        testCollection = new ArrayCollection<>();
        testCollection.add(1);
        testCollection.add(2);
        assertTrue(arrayCollection.removeAll(testCollection));
        assertTrue(arrayCollection.isEmpty());
    }

    @Test
    void retainAll() {
        testCollection = new ArrayCollection<>();
        testCollection.add(1);
        testCollection.add(2);
        arrayCollection.add(3);
        arrayCollection.retainAll(testCollection);
        assertArrayEquals(testIntegerArray, arrayCollection.getArray());

    }

    @Test
    void clear() {
        arrayCollection.clear();
        assertEquals(EMPTY_ARRAY_SIZE, arrayCollection.size());
    }
}