package com.will.tinyspring.beans.factory;

import com.will.tinyspring.beans.BeansException;

/**
 * @program: Tiny-Spring
 * @description: Bean工厂接口，定义了获取bean的方法
 * @author: Mr.Zhang
 * @create: 2025-04-08 17:24
 **/

public interface BeanFactory {
    /**
     * 根据bean的名称获取bean
     * @param name bean的名称
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 根据bean的名称获取bean
     * @param name bean的名称
     * @param requiredType 获取bean的类型
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name,Class<T> requiredType) throws BeansException;

    /**
     *
     * 根据bean的名称获取bean
     * @param requiredType 获取bean的类型
     * @return
     * @throws BeansException
     * */
    <T> T getBean(Class<T> requiredType) throws BeansException;

    /**
     * 判断是否包含指定名称的bean
     *
     * @param name
     * @return 包含返回true，不包含返回false
     * */
    boolean containsBean(String name);

    /**
     * 判断指定名称的bean是否是原型
     *
     * @param name bean的名称
     * @return 是原型返回true，不是原型返回false
     * @throws BeansException 如果获取不到bean，抛出异常
     * */
    boolean isSingleton(String name) throws BeansException;

    /**
     * 获取指定名称bean的类型
     *
     * @param name bean的名称
     * @return bean的类型
     * @throws BeansException 如果获取不到bean的类型，抛出异常
     * */
    Class<?> getType(String name) throws BeansException;
}
