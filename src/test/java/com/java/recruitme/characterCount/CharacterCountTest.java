package com.java.recruitme.characterCount;

import org.junit.Assert;
import org.junit.Test;

import com.java.recruitme.characterCount.CharacterCount;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Test for @{@link CharacterCount}
 * Problem statement : Given a string, find out the number of occurrences of each character.
 * For eg. Given the string 'a@ppleE@' , occurrence of each character is as follows
 * a - 1
 * p - 2
 * l - 1
 * e - 1
 * E - 1
 * @ -2
 *
 * Characters are case sensitive , a is different from A
 * Also white spaces are not considered and hence can be ignored.
 * Special characters are to be considered.
 * A correct implementation will pass all the tests.
 */
public class CharacterCountTest {

  @Test
  public void shouldReturnEmptyMapIfStringIsEmpty() {
    Map<Character, Integer> characterCount = CharacterCount.countCharacters("");
    Map<Character, Integer> expectedCharacterCount = new LinkedHashMap<Character, Integer>();
    Assert.assertEquals(expectedCharacterCount, characterCount);
  }

  @Test
  public void shouldReturnCorrectCountIfStringContainsOneCharacter() {
    Map<Character, Integer> characterCount = CharacterCount.countCharacters("T");
    Map<Character, Integer> expectedCharacterCount = new LinkedHashMap<Character, Integer>();
    expectedCharacterCount.put('T', 1);
    Assert.assertEquals(expectedCharacterCount, characterCount);
  }

  @Test
  public void shouldReturnCorrectCountIfStringContainsOneWord() {
    Map<Character, Integer> characterCount = CharacterCount.countCharacters("Apple");
    Map<Character, Integer> expectedCharacterCount = new LinkedHashMap<Character, Integer>() {{
      put('A', 1);
      put('p', 2);
      put('l', 1);
      put('e', 1);
    }};

    Assert.assertEquals(expectedCharacterCount, characterCount);
  }

  @Test
  public void shouldReturnCorrectCountIfStringContainsOneSentence() {
    Map<Character, Integer> characterCount = CharacterCount.countCharacters("Hello hari!!");
    Map<Character, Integer> expectedCharacterCount = new LinkedHashMap<Character, Integer>() {{
      put('H', 1);
      put('e', 1);
      put('l', 2);
      put('o', 1);
      put('h', 1);
      put('a', 1);
      put('r', 1);
      put('i', 1);
      put('!', 2);
    }};
    
    Assert.assertEquals(expectedCharacterCount, characterCount);
  }

  
  @Test
  public void shouldReturnEmptyMapIfStringContainsOnlySpaces() {
    Map<Character, Integer> characterCount = CharacterCount.countCharacters("   ");
    Map<Character, Integer> expectedCharacterCount = new LinkedHashMap<Character, Integer>();
    Assert.assertEquals(expectedCharacterCount, characterCount);
  }
  

}
