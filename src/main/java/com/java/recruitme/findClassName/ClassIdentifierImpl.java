package com.java.recruitme.findClassName;

import com.java.recruitme.services.MethodNotImplementedException;

public class ClassIdentifierImpl<T, E> implements ClassIdentifier<T, E> {
  public String[] identifyClasses(T parameterOne, E parameterTwo) throws Exception {
	String[] strings = new String[2];
	strings[0] = parameterOne.getClass().getSimpleName();
	strings[1] = parameterTwo.getClass().getSimpleName();
    return strings;
  }
}
