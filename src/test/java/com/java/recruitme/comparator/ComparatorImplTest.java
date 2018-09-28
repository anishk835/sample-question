package com.java.recruitme.comparator;

import org.junit.Assert;
import org.junit.Test;

import com.java.recruitme.comparator.Comparator;
import com.java.recruitme.comparator.ComparatorImpl;

/**
 * Test for @{@link ComparatorImpl}
 * Create a generic class which will return the greater of two items passed.
 * eg.
 * comparator.findGreater(5,10) should return 10
 * comparator.findGreater(10,5) should return 10
 * comparator.findGreater('j','a') should return j
 *
 * A correct implementation will pass all the tests.
 */
public class ComparatorImplTest {

  @Test
  public void shouldGiveGreaterOfTwoIntegers() throws Exception {
    Comparator comparator = new ComparatorImpl();
    Assert.assertEquals(10, comparator.findGreater(5, 10));
  }

  @Test
  public void shouldGiveGreaterOfTwoCharacters() throws Exception {
    Comparator comparator = new ComparatorImpl();
    Assert.assertEquals('j', comparator.findGreater('j', 'a'));
  }

  @Test
  public void shouldGiveGreaterOfTwoFloatingPointNumbers() throws Exception {
    Comparator comparator = new ComparatorImpl();
    Assert.assertEquals(9.885, comparator.findGreater(9.88, 9.885));
  }

  @Test
  public void shouldGiveGreaterOfTwoStrings() throws Exception {
    Comparator comparator = new ComparatorImpl();
    Assert.assertEquals("ThoughtWorks", comparator.findGreater("ThoughtWorks", "ThoughtWorked"));
  }

  @Test
  public void shouldGiveAnyOfTwoEqualNumbers() throws Exception {
    Comparator comparator = new ComparatorImpl();
    Assert.assertEquals(10, comparator.findGreater(10, 10));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionIfInputsAreOfDifferentTypes() throws Exception {
    Comparator comparator = new ComparatorImpl();
    comparator.findGreater("apple", 100);
  }

}
