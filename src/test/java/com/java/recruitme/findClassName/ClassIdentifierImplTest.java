package com.java.recruitme.findClassName;

import org.junit.Assert;
import org.junit.Test;

import com.java.recruitme.findClassName.Animal;
import com.java.recruitme.findClassName.ClassIdentifier;
import com.java.recruitme.findClassName.ClassIdentifierImpl;

/**
 * Test for @{@link ClassIdentifierImpl}
 *
 * You are a hacker! And you wanted to tear apart enemy software system. only if we could find out the name the
 * class being used.You do not have access to their source code or binaries.
 * A mole will drop your binaries into the system and that is the only opportunity you have !
 */
public class ClassIdentifierImplTest {

  @Test
  public void shouldReturnClassNameOfIntegerIfBothParametersAreIntegers() throws Exception {
    ClassIdentifier identifier = new ClassIdentifierImpl();
    String[] expectedTypes = new String[]{"Integer", "Integer"};
    Integer one = 1;
    Integer two = 2;
    Assert.assertArrayEquals(expectedTypes, identifier.identifyClasses(one, two));
  }

  @Test
  public void shouldReturnClassNameOfIntegerAndString() throws Exception {
    ClassIdentifier identifier = new ClassIdentifierImpl();
    String[] expectedTypes = new String[]{"Integer", "String"};
    Integer one = 1;
    Assert.assertArrayEquals(expectedTypes, identifier.identifyClasses(one, "pie"));
  }

  @Test
  public void shouldReturnClassNameOfAnimalAndString() throws Exception {
    ClassIdentifier identifier = new ClassIdentifierImpl();
    String[] expectedTypes = new String[]{"Animal", "String"};
    Animal animal = new Animal();
    Assert.assertArrayEquals(expectedTypes, identifier.identifyClasses(animal, "pie"));
  }
}
