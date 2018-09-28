package com.java.recruitme.services;

import java.util.Random;
import java.util.Stack;

/**
 * Do not change code here.
 */

public class ExceptionService {

    private Stack<RandomException> exceptions = new Stack<RandomException>();

    public void throwException() throws RandomException {
        int randomCode = new Random().nextInt();
        RandomException randomException = new RandomException(new RandomError(randomCode));
        exceptions.push(randomException);
        throw randomException;
    }

    public RandomException getLastExceptionThrown(){
        return exceptions.pop();
    }
}
