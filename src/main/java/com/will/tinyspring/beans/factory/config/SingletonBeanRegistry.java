package com.will.tinyspring.beans.factory.config;

/**
 * 单例bean注册表接口
 * 定义了管理单例bean的基本操作
 *
 * @author Will
 * @date 2025/4/8 16:06
 * */

public interface SingletonBeanRegistry {
    /**
     * 注册一个单例bean
     *
     * @param beanName bean的名称
     * @param singletonObject 单例bean实例
     * */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * 获取一个单例bean
     *
     * @param beanName bean的名称
     * @return 单例bean实例
     * */
    Object getSingleton(String beanName);

    /**
     * 判断是否包含指定名称的单例bean
     *
     * @param beanName bean的名称
     * @return true表示包含，false表示不包含
     * */
    boolean containsSingleton(String beanName);

    /**
     * 获取所有单例bean的名称
     *
     * @return 单例bean的名称数组
     * */
    String[] getSingletonNames();

    /**
     * 获取单例bean的数量
     *
     * @return 单例bean的数量
     * */
    int getSingletonCount();
}
