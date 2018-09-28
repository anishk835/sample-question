package com.java.recruitme.expressionValidator;

import org.junit.Assert;
import org.junit.Test;

import com.java.recruitme.expressionValidator.ExpressionValidator;
import com.java.recruitme.expressionValidator.ExpressionValidatorImpl;

/**
 * Lets create a compiler .. well sort of..
 * Write a validator that checks that all the open braces within an expression are closed.
 * {Here} is a valid expression as { has been closed with }
 * {{ is invalid expression as { and {  have not been closed.
 */
public class ExpressionValidatorTest {

    @Test
    public void givenExpressionIsBalancedExpression() throws Exception {
        ExpressionValidator expressionValidator = new ExpressionValidatorImpl();
        Assert.assertTrue(expressionValidator.isBalancedExpression("{{[[(())]]}}"));
    }

    @Test
    public void givenExpressionIsNotABalancedExpression() throws Exception {
        ExpressionValidator expressionValidator = new ExpressionValidatorImpl();
        Assert.assertFalse(expressionValidator.isBalancedExpression("}{"));
        Assert.assertFalse(expressionValidator.isBalancedExpression("{{[[(())]]}}("));
    }
}