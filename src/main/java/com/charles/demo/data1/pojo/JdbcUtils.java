package com.charles.demo.data1.pojo;

import oracle.jdbc.OracleConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Charles
 * @Description 原生jdbc工具类 测试学习面试使用
 */
public class JdbcUtils {
    public static OracleConnection getConn() {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@DESKTOP-QA8UILO/citygis";
        String username = "system";
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

