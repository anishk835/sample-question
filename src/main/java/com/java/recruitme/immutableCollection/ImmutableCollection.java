package com.java.recruitme.immutableCollection;

public interface ImmutableCollection<E> {
    ImmutableCollection<E> add(E e) throws Exception;
    ImmutableCollection<E> remove(E e) throws Exception;
    int size() throws Exception;
}
