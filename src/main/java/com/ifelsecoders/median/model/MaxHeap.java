package com.ifelsecoders.median.model;

public class MaxHeap extends AbstractHeap<Integer> {
    @Override
    protected boolean bubblingCheck(int parentKey, int keyId) {
        return (Integer) storage[parentKey] < (Integer) storage[keyId];
    }
}
