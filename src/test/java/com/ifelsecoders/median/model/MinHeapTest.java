package com.ifelsecoders.median.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}