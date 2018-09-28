package com.java.recruitme.immutableCollection;

import java.util.Collection;
import java.util.Collections;

import com.java.recruitme.services.MethodNotImplementedException;

public class ImmutableCollectionImpl<E> implements ImmutableCollection<E> {
    private final Collection<E> immutableCollection;

    public ImmutableCollectionImpl(Collection<E> collection) {
        this.immutableCollection = collection;
    }
    public ImmutableCollection<E> add(E e) throws Exception {
    	
        //return new ImmutableCollectionImpl<E>(immutableCollection).immutableCollection.add(e);
        throw new MethodNotImplementedException("remove");
    }

    public ImmutableCollection<E> remove(E e) throws Exception {
        throw new MethodNotImplementedException("remove");
    }

    public int size() {
        return immutableCollection.size();
    }
}
