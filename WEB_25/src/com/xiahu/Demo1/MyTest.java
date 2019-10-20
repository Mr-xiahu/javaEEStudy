package com.xiahu.Demo1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自己写的注解
 * @author Administrator
 *
 *元注解:
 * 元注解的可见范围:
 *     @Retention(RetentionPolicy.RUNTIME)------运行时级别
 *     @Retention(RetentionPolicy.CLASS)--------字节码级别
 *     @Retention(RetentionPolicy.SOURCE)-------源码级别
 *     
 *      @Retention(RetentionPolicy.RUNTIME)---> @Retention(RetentionPolicy.CLASS)---->@Retention(RetentionPolicy.SOURCE)
 *
 */
@Target(ElementType.METHOD)//只能用在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
	// 没有参数,所有内部不用任何属性

}
