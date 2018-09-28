package com.java.recruitme.immutableCollection;

import org.junit.Assert;
import org.junit.Test;

import com.java.recruitme.immutableCollection.ImmutableCollection;
import com.java.recruitme.immutableCollection.ImmutableCollectionImpl;

import java.util.Arrays;

/**
 * Test for @{@link ImmutableCollectionImpl}
 * A collection once created,never changes again !!
 * No one can mess around with this collection not even multiple threads.
 */
public class ImmutableCollectionTest {

    @Test
    public void shouldAddNewElementToImmutableCollection() throws Exception {
        String[] strings = new String[]{"Element1", "Element2"};
        ImmutableCollection<String> immutableCollection = new ImmutableCollectionImpl<String>(Arrays.asList(strings));
        ImmutableCollection<String> newImmutableCollection = immutableCollection.add("newElement");
        Assert.assertEquals(2, immutableCollection.size());
        Assert.assertEquals(3, newImmutableCollection.size());
    }

    @Test
    public void shouldBeAbleToRemoveAnElementFromImmutableCollection() throws Exception {
        String[] strings = new String[]{"Element1", "Element2"};
        ImmutableCollection<String> immutableCollection = new ImmutableCollectionImpl<String>(Arrays.asList(strings));
        ImmutableCollection<String> newImmutableCollection = immutableCollection.remove("Element1");
        Assert.assertEquals(2, immutableCollection.size());
        Assert.assertEquals(1, newImmutableCollection.size());
    }
}
