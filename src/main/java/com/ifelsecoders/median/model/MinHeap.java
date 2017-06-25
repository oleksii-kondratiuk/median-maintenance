package com.ifelsecoders.median.model;

public class MinHeap extends AbstractHeap<Integer> {

    public MinHeap() {
        storage = new Integer[DEFAUL_STORAGE_LENGTH];
    }

    public MinHeap(int storageLength) {
        storage = new Integer[storageLength];
    }

    @Override
    protected boolean bubblingCheck(int parentKey, int keyId) {
        return (Integer) storage[parentKey] > (Integer) storage[keyId];
    }
}
