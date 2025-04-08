package com.will.tinyspring.beans.factory;

public interface BeanNameAware extends Aware{
    /**
     * 设置bean在容器中的名字
     *
     * @param name bean在容器中的名字
     * */
    void setBeanName(String name);
}
