package com.java.recruitme.exceptions;

import org.junit.Assert;
import org.junit.Test;

import com.java.recruitme.exceptions.ErraticServiceImpl;
import com.java.recruitme.services.ErraticService;
import com.java.recruitme.services.ExceptionService;
import com.java.recruitme.services.RandomError;
import com.java.recruitme.services.RandomException;

/**
 * Test for @{@link ErraticServiceImpl}
 * Can you play around with fiery exceptions ?
 */
public class ErraticServiceTest {
    @Test
    public void shouldReturnErrorCodeInCaseOfException() throws Exception {
        ErraticService erraticServiceTest = new ErraticServiceImpl();
        ExceptionService stubService = new ExceptionService();
        RandomError randomError = erraticServiceTest.execute(stubService);
        RandomException lastExceptionThrown = stubService.getLastExceptionThrown();

        Assert.assertEquals(lastExceptionThrown.getError().getCode(), randomError.getCode());
    }
}
