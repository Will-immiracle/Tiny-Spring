package com.will.tinyspring.beans;

/**
 * @program: Tiny-Spring
 * @description: Bean异常类
 * @author: Mr.Zhang
 * @create: 2025-04-08 17:24
 **/

public class BeansException extends RuntimeException{
    /**
     * 创建一个新的BeanException实例
     *
     * @param msg 异常信息
     * */
    public BeansException(String msg){
        super(msg);
    }
    /**
     * 创建一个新的BeanException实例
     *
     * @param msg 异常信息
     * @param cause 异常原因
     * */
    public BeansException(String msg, Throwable cause){
        super(msg, cause);
    }
}
