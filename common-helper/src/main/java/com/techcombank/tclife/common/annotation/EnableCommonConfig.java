package com.techcombank.tclife.common.annotation;

import com.techcombank.tclife.common.client.GlobalFeignClientConfig;
import com.techcombank.tclife.common.context.PortalContextConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Import({
        PortalContextConfig.class,
        GlobalFeignClientConfig.class
})
@ComponentScan(basePackages = {
        "com.techcombank.tclife.common.exception",
        "com.techcombank.tclife.common.context",
        "com.techcombank.tclife.common.client"

})
public @interface EnableCommonConfig{
}
