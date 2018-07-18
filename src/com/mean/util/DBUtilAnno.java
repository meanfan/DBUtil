package com.mean.util;
import com.mean.util.anno.JDBCConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: DBUtil
 * @description: DBUtil注解方式
 * @author: MeanFan
 * @create: 2018-07-13 17:18
 **/
@JDBCConfig(ip = "127.0.0.1",
        database = "dev_test",
        encoding = "UTF-8",
        useSSL = false,
        serverTimeZone = "+8:00",
        loginName = "java_dev",
        password = "dev000")  //以注解的方式提供信息
public class DBUtilAnno {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        JDBCConfig config = DBUtilAnno.class.getAnnotation(JDBCConfig.class);//通过反射获取DBUtil类的注解对象
        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        boolean useSSL = config.useSSL();
        String serverTimeZone = config.serverTimeZone();
        String loginName = config.loginName();
        String password = config.password();
        String url = String.format("jdbc:mysql://%s:%d/%s?" +
                        "characterEncoding=%s" +
                        "&useSSL=%b" +
                        "&allowPublicKeyRetrieval=true" +
                        "&serverTimeZone=%s",
                ip,port,database,encoding,useSSL, serverTimeZone);
        return DriverManager.getConnection(url,loginName,password);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        System.out.println(connection);
    }
}
