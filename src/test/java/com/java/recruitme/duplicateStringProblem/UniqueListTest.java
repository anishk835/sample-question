package com.java.recruitme.duplicateStringProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for @{@link UniqueList}
 * Complete the implementation of @{@link UniqueList} so that it will hold only unique items.
 *
 * UniqueList.DeDuplicate(Arrays.AsList("foo",""bar,"foo")) should return a list with 1 "foo" and 1 "bar"
 */
public class UniqueListTest {

  @Test
  public void shouldReturnEmptyListIfInputListIsEmpty(){
    List<String> duplicateList = new ArrayList<String>();
    List<String> uniqueList = UniqueList.deDuplicate(duplicateList);
    List<String> expectedUniqueList = new ArrayList<String>();
    Assert.assertEquals(expectedUniqueList, uniqueList);
  }

  @Test
  public void shouldReturnSameListIfInputListHasOneString(){
    List<String> duplicateList = new ArrayList<String>();
    duplicateList.add("ThoughtWorks");
    List<String> uniqueList = UniqueList.deDuplicate(duplicateList);
    List<String> expectedUniqueList = new ArrayList<String>(Arrays.asList("ThoughtWorks"));
    Assert.assertEquals(expectedUniqueList, uniqueList);
  }

  @Test
  public void shouldRemoveOneDuplicateStringIfInputListHasTwoSameStrings(){
    List<String> duplicateList = new ArrayList<String>();
    duplicateList.add("ThoughtWorks");
    duplicateList.add("ThoughtWorks");
    List<String> uniqueList = UniqueList.deDuplicate(duplicateList);
    List<String> expectedUniqueList = new ArrayList<String>(Arrays.asList("ThoughtWorks"));
    Assert.assertEquals(expectedUniqueList, uniqueList);
  }

  @Test
  public void shouldRemoveDuplicateAndMaintainOrderInInputListsWithDuplicateElements(){
    List<String> duplicateList = new ArrayList<String>(Arrays.asList("orange", "apple", "banana", "apple"));
    List<String> uniqueList = UniqueList.deDuplicate(duplicateList);
    List<String> expectedUniqueList = new ArrayList<String>(Arrays.asList("orange", "apple", "banana"));
    Assert.assertEquals(expectedUniqueList, uniqueList);
  }
  
}
