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
        if(bubblingUpCheck(parentKey, keyId)) {
            Integer temp = (Integer) storage[parentKey];
            storage[parentKey] = storage[keyId];
            storage[keyId] = temp;
            bubbleUp(parentKey);
        }
    }

    @Override
    public T extractTopValue() {
        T topValue = (T) storage[0];
        storage[0] = storage[numberOfElementsInArray - 1];

        bubbleDown(0);

        return topValue;
    }

    private void bubbleDown(int keyId) {
        int childItemToExchangeId = getItemIdToExchange(keyId);
        T temp = (T) storage[childItemToExchangeId];
        storage[childItemToExchangeId] = storage[keyId];
        storage[keyId] = temp;

        if(bubblingDownCheck(childItemToExchangeId)) {
            bubbleDown(childItemToExchangeId);
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

    protected abstract boolean bubblingUpCheck(int parentKey, int keyId);

    protected abstract boolean bubblingDownCheck(int parentKey);

    protected abstract int getItemIdToExchange(int keyId);
}
