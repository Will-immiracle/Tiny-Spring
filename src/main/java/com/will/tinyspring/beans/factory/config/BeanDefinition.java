package com.will.tinyspring.beans.factory.config;

/**
 * Bean定义接口
 * 定义一个Bean的所有属性
 *
 * @author Will
 * @date 2025/4/8 19:39
 * */
public interface BeanDefinition {
    /**
     * 单例作用域
     * */

    String SCOPE_SINGLETON = "singleton";
    /**
     * 原型作用域
     * */
    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 设置Bean的Class对象
     *
     * @param beanClass Bean的Class对象
     * */
    void setBeanClass(Class<?> beanClass);

    /**
     * 获取Bean的Class对象
     *
     * @return Bean的Class对象
     * */
    Class<?> getBeanClass();

    /**
     * 设置Bean的作用域
     *
     * @param scope Bean的作用域
     * */
    void setScope(String scope);

    /**
     * 获取Bean的作用域
     *
     * @return Bean的作用域
     * */
    String getScope();

    /**
     * 是否是单例
     *
     * @return 是否是单例
     * */
    boolean isSingleton();

    /**
     * 是否是原型
     *
     * @return 是否是原型
     * */
    boolean isPrototype();

    /**
     * 是否延迟初始化
     *
     * @return 如果延迟初始化返回true，否则返回false
     * */
    boolean isLazyInit();

    /**
     * 设置初始化方法名
     *
     * @param initMethodName 初始化方法名
     * */
    void setInitMethodName(String initMethodName);

    /**
     * 获取初始化方法名
     *
     * @return 初始化方法名
     * */
    String getInitMethodName();

    /**
     * 设置销毁方法名
     *
     * @param destroyMethodName 销毁方法名
     * */
    void setDestroyMethodName(String destroyMethodName);

    /**
     * 获取销毁方法名
     *
     * @return 销毁方法名
     * */
    String getDestroyMethodName();

    void setPropertyValues(PropertyValues propertyValues);
}
