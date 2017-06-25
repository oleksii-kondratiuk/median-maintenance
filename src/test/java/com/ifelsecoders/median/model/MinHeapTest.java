package com.ifelsecoders.median.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MinHeapTest {

    private MinHeap minHeap;

    @Before
    public void init() {
        minHeap = new MinHeap();
    }

    @Test
    public void insertMinimal() {
        minHeap.insert(2);
        minHeap.insert(4);
        minHeap.insert(6);

        assertEquals(minHeap.storage[0], 2);
        assertEquals(minHeap.storage[1], 4);
        assertEquals(minHeap.storage[2], 6);

        minHeap.insert(3);

        assertEquals(minHeap.storage[0], 2);
        assertEquals(minHeap.storage[1], 3);
        assertEquals(minHeap.storage[2], 6);
        assertEquals(minHeap.storage[3], 4);
    }

    @Test
    public void extractMinimal() {
        minHeap.insert(2);
        minHeap.insert(4);
        minHeap.insert(6);
        minHeap.insert(7);

        assertEquals(2, minHeap.storage[0]);
        assertEquals(4, minHeap.storage[1]);
        assertEquals(6, minHeap.storage[2]);
        assertEquals(7, minHeap.storage[3]);

        assertEquals(2, minHeap.extractTopValue().intValue());
        assertEquals(3, minHeap.size());

        assertEquals(minHeap.storage[0], 4);
        assertEquals(minHeap.storage[1], 7);
        assertEquals(minHeap.storage[2], 6);
        assertNull(minHeap.storage[3]);
    }

    @Test
    public void checkMinimal() {
        minHeap.insert(2);
        minHeap.insert(4);
        minHeap.insert(6);

        assertEquals(2, minHeap.storage[0]);
        assertEquals(4, minHeap.storage[1]);
        assertEquals(6, minHeap.storage[2]);

        assertEquals(2, minHeap.checkTopValue().intValue());

        assertEquals(2, minHeap.storage[0]);
        assertEquals(4, minHeap.storage[1]);
        assertEquals(6, minHeap.storage[2]);
    }
}