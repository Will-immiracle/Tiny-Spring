package com.will.tinyspring.beans.factory.annotation;

/**
 * @program: Tiny-Spring
 * @description: 标记需要注入的属性
 * @author: Mr.Zhang
 * @create: 2025-04-08 17:24
 **/

import java.lang.annotation.*;

/**
 * @author: Mr.Zhang
 * @create: 2025-04-08 17:24
 **/

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {
    /**
     * 声明该依赖是否是必须的
     * 如果为true，且找不到依赖的bean，抛出异常
     * 如果是false，找不到bean时会跳过注入
     * @return 依赖是否是必须的
     * */
    boolean required() default true;
}
