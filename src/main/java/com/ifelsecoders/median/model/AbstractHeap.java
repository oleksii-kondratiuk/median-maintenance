package com.ifelsecoders.median.model;

public abstract class AbstractHeap<T extends Number> implements Heap<T> {

    protected static final int DEFAUL_STORAGE_LENGTH = 10;

    protected Object[] storage;
    protected int numberOfElementsInArray = 0;

    @Override
    public void insert(T object) {
        if (numberOfElementsInArray == storage.length - 1) {
            Object[] tempStorage = storage;
            // TODO define proper strategy for storage extension
            storage = new Object[storage.length * 2];
            System.arraycopy(tempStorage, 0, storage, 0, tempStorage.length - 1);
        }

        storage[numberOfElementsInArray] = object;
        bubbleUp(numberOfElementsInArray);

        numberOfElementsInArray++;
    }

    private void bubbleUp(Integer keyId) {
        int parentKey = getParentKey(keyId);
        if(bubblingCheck(parentKey, keyId)) {
            Integer temp = (Integer) storage[parentKey];
            storage[parentKey] = storage[keyId];
            storage[keyId] = temp;
            bubbleUp(parentKey);
        }
    }

    protected int getParentKey(int key) {
        if(key == 0) {
            return 0;
        }
        if(key % 2 == 0) {
            return key / 2 - 1;
        }
        return key / 2;
    }

    protected abstract boolean bubblingCheck(int parentKey, int keyId);
}
