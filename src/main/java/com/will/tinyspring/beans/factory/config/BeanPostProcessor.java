package com.will.tinyspring.beans.factory.config;

import com.will.tinyspring.beans.BeansException;

/**
 * @program: Tiny-Spring
 * @description: Bean后置处理接口，允许自定义修改bean实例的工厂钩子
 * @author: Mr.Zhang
 * @create: 2025-04-08 18:51
 **/
public interface BeanPostProcessor {

    /**
     * 在bean初始化之前应用此BeanPostProcessor
     *
     * @param bean bean实例
     * @param beanName bean名称
     * @return 要使用的bean实例，可以是原始的，也可以是包装后的
     * @throws BeansException 在处理过程中发生错误
     * */
    default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
        return bean;
    }
}
