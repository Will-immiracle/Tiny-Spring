package com.will.tinyspring.beans.factory;

/**
 * @program: Tiny-Spring
 * @description: 分层的bean工厂接口，定义了bean工厂的父子关系
 * @author: Mr.Zhang
 * @create: 2025-04-08 18:51
 **/

public interface HierarchicalBeanFactory {

    /**
     * 获取父bean工厂
     *
     * @return 父bean工厂，如果没有返回null
     */
    BeanFactory getParentBeanFactory();

    /**
     * 判断当前bean工厂是否包含指定名称的bean
     *
     * @param name bean名称
     * @return true表示包含，false表示不包含
     */
    boolean containsLocalBean(String name);


}
