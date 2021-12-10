package db;

/**
 * @description: 数据库服务
 * @author: dongjunjie
 * @date: 2021/12/10 14:37
 */

import java.sql.*;

public class DbServer {

    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/sqlinjectiontest";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    public String query(String name) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        String msg = "";
        Class.forName(JDBC_DRIVER);
        System.out.println("连接数据库...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println(" 实例化Statement对象...");
        stmt = conn.createStatement();
        String sql = "SELECT * FROM sqlinjectiontest where name = " + "\'" + name + "\'";
        System.out.println("拼接后的sql:" + sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            msg += "name : " + rs.getString("name") + " age : " + rs.getString("age");
        }
        rs.close();
        stmt.close();
        conn.close();
        return msg;
    }
}
