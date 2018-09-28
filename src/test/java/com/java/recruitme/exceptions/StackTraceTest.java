package com.java.recruitme.exceptions;

import org.junit.Assert;
import org.junit.Test;

import com.java.recruitme.services.StackTrace;

public class StackTraceTest {
    @Test
    public void shouldClearInheritedStackTrace() {
        StackTrace stacktrace = new StackTraceImpl();
        try {
            stacktrace.clearStackTrace();
        } catch (Exception e) {
            Assert.assertEquals("clearStackTrace", e.getStackTrace()[0].getMethodName());
        }
    }
}
