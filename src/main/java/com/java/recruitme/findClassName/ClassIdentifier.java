package com.java.recruitme.findClassName;

public interface ClassIdentifier<T, E> {
  String[] identifyClasses(T parameterOne, E parameterTwo) throws Exception;
}
