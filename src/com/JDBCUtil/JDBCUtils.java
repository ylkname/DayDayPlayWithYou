package com.JDBCUtil;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类 使用Durid连接池
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            //使用ClassLoader加载配置文件，获取字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void close(Connection connection){
        JDBCUtils.close(connection,null,null);
    }
    public static void close(Connection connection, PreparedStatement preparedStatement){
        JDBCUtils.close(connection,preparedStatement,null);
    }
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try{
            if(resultSet!=null)
                resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(preparedStatement!=null)
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection!=null)
                connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
