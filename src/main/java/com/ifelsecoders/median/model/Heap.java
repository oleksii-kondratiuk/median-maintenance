package com.ifelsecoders.median.model;

public interface Heap<T extends Number> {

    void insert(T object);

    T extractTopValue();

    T checkTopValue();

    int size();
}
