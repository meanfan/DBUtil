package com.mean.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: DBUtil
 * @description: DBUtil非注解方式
 * @author: MeanFan
 * @create: 2018-07-13 16:25
 **/
public class DBUtil {
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "dev_test";
    static String encoding = "UTF-8";
    static boolean useSSL = false;
    static String serverTimeZone = "+8:00";
    static String loginName = "java_dev";
    static String password = "dev000";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?" +
                "characterEncoding=%s" +
                "&useSSL=%b" +
                "&allowPublicKeyRetrieval=true" +
                "&serverTimeZone=Asia/Shanghai",
                ip,port,database,encoding,useSSL, serverTimeZone);
        return DriverManager.getConnection(url,loginName,password);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
