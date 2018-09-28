package com.java.recruitme.expressionValidator;

import com.java.recruitme.services.MethodNotImplementedException;

public interface ExpressionValidator {
    boolean isBalancedExpression(String expression) throws MethodNotImplementedException;
}
