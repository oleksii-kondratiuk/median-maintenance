package com.ifelsecoders.median.model;

public class MaxHeap extends AbstractHeap<Integer> {

    public MaxHeap() {
        storage = new Integer[DEFAUL_STORAGE_LENGTH];
    }

    public MaxHeap(int storageLength) {
        storage = new Integer[storageLength];
    }

    @Override
    protected boolean bubblingCheck(int parentKey, int keyId) {
        return (Integer) storage[parentKey] < (Integer) storage[keyId];
    }
}
