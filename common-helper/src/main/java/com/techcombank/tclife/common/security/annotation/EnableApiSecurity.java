package com.techcombank.tclife.common.security.annotation;

import com.techcombank.tclife.common.security.configuration.ApiSecurityConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({ApiSecurityConfiguration.class})
public @interface EnableApiSecurity {
}
