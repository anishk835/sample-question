package com.java.recruitme.exceptions;


import com.java.recruitme.services.ErraticService;
import com.java.recruitme.services.ExceptionService;
import com.java.recruitme.services.RandomError;

public class ErraticServiceImpl implements ErraticService {
    public RandomError execute(ExceptionService stubService){
        stubService.throwException();
        return new RandomError(-1);
    }
}
