package com.mean.util.anno;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @program: DBUtil
 * @description: 自定义注解@JDBCConfig
 * @author: MeanFan
 * @create: 2018-07-13 17:07
 **/
@Target({METHOD,TYPE})    //可以用用在类/接口/方法上
@Retention(RetentionPolicy.RUNTIME) //是运行时注解
@Inherited                //可以被子类继承
@Documented               //执行javadoc时本注解会生成相关文档
public @interface JDBCConfig {
    String ip();
    int port() default 3306;
    String database();
    String encoding();
    boolean useSSL();
    String serverTimeZone();
    String loginName();
    String password();
}
