package com.ifelsecoders.median.model;

public class MaxHeap extends AbstractHeap<Integer> {

    public MaxHeap() {
        storage = new Integer[DEFAUL_STORAGE_LENGTH];
    }

    public MaxHeap(int storageLength) {
        storage = new Integer[storageLength];
    }

    @Override
    protected boolean bubblingUpCheck(int parentKey, int keyId) {
        return (Integer) storage[parentKey] < (Integer) storage[keyId];
    }

    @Override
    protected boolean bubblingDownCheck(int parentKey) {
        return (storage[2 * parentKey + 1] != null
                && (Integer) storage[parentKey] < (Integer) storage[2 * parentKey + 1])
                || (storage[2 * parentKey + 2] != null
                &&(Integer) storage[parentKey] < (Integer) storage[2 * parentKey + 2]);
    }

    @Override
    protected int getItemIdToExchange(int keyId) {
        if((Integer) storage[2 * keyId + 1] <= (Integer) storage[2 * keyId + 2]) {
            return 2 * keyId + 2;
        }
        return 2 * keyId + 1;
    }
}
