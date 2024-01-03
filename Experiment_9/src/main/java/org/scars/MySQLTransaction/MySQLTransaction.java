package org.scars.MySQLTransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLTransaction {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test"; // 数据库地址
        String user = "root"; // 数据库用户名
        String password = "password"; // 数据库密码
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false); // 关闭自动提交，以便使用事务

            // 在person表中插入记录
            String insertSql = "INSERT INTO person (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setInt(1, 1);
            insertStmt.setString(2, "Tom");
            insertStmt.setInt(3, 20);
            insertStmt.executeUpdate();

            insertStmt.setInt(1, 2);
            insertStmt.setString(2, "Jerry");
            insertStmt.setInt(3, 18);
            insertStmt.executeUpdate();

            // 更新person表中的记录
            String updateSql = "UPDATE person SET name=? WHERE id=?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setString(1, "Jack");
            updateStmt.setInt(2, 1);
            updateStmt.executeUpdate();

            // 删除person表中的记录
            String deleteSql = "DELETE FROM person WHERE id=?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
            deleteStmt.setInt(1, 2);
            deleteStmt.executeUpdate();

            conn.commit(); // 提交事务

            // 关闭声明和连接
            insertStmt.close();
            updateStmt.close();
            deleteStmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // 出现异常，回滚事务
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
