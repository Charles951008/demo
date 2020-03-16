package com.charles.demo.tools;

import oracle.jdbc.OracleConnection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Charles
 * @Description 原生jdbc工具类 测试学习面试使用
 */
public class JdbcUtils {
    public static OracleConnection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.1.4:3306/charles?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false";
        String username = "root";
        String password = "233666";
        OracleConnection conn = null;
        try {
            Class.forName(driver);
            conn = (OracleConnection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

