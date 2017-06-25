package com.ifelsecoders.median.model;

public class MinHeap extends AbstractHeap<Integer> {

    public MinHeap() {
        storage = new Integer[DEFAUL_STORAGE_LENGTH];
    }

    public MinHeap(int storageLength) {
        storage = new Integer[storageLength];
    }

    @Override
    protected boolean bubblingUpCheck(int parentKey, int keyId) {
        return (Integer) storage[parentKey] > (Integer) storage[keyId];
    }

    @Override
    protected boolean bubblingDownCheck(int parentKey) {
        return (2 * parentKey + 1 < storage.length && storage[2 * parentKey + 1] != null
                && (Integer) storage[parentKey] > (Integer) storage[2 * parentKey + 1])
                || (2 * parentKey + 2 < storage.length && storage[2 * parentKey + 2] != null
                && (Integer) storage[parentKey] > (Integer) storage[2 * parentKey + 2]);
    }

    @Override
    protected Integer getItemIdToExchange(int keyId) {
        if(storage[2 * keyId + 1] == null && storage[2 * keyId + 2] == null) {
            return null;
        }

        if(storage[2 * keyId + 1] != null && storage[2 * keyId + 2] == null) {
            return 2 * keyId + 1;
        }

        if(storage[2 * keyId + 1] == null && storage[2 * keyId + 2] != null) {
            return 2 * keyId + 2;
        }

        if((Integer) storage[2 * keyId + 1] >= (Integer) storage[2 * keyId + 2]) {
            return 2 * keyId + 2;
        }
        return 2 * keyId + 1;
    }


}
