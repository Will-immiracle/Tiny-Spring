package com.will.tinyspring.beans.factory.config;

import com.will.tinyspring.beans.factory.BeanFactory;
import com.will.tinyspring.beans.factory.HierarchicalBeanFactory;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    /**
     * 单例作用域标识符
     * */
    String SCOPE_SINGLETON = "singleton";

    /**
     * 原型作用域标识符
     * */
    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 设置父bean工厂
     *
     * @param parentBeanFactory 父bean工厂
     * */
    void setParentBeanFactory(ConfigurableBeanFactory parentBeanFactory);

    /**
     * 设置类加载器
     *
     * @param beanClassLoader 类加载器
     * */
    void setBeanClassLoader(ClassLoader beanClassLoader);

    /**
     * 获取类加载器
     *
     * @return 类加载器
     * */
    ClassLoader getBeanClassLoader();

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
