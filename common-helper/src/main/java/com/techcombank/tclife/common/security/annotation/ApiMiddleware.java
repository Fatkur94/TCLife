package com.techcombank.tclife.common.security.annotation;

import com.techcombank.tclife.common.security.model.ApiAccessScope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiMiddleware {
    ApiAccessScope[] scope();
}

