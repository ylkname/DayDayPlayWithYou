package com.DAO.DAOImpl;

import com.Bean.PlayMenOrder;
import com.Bean.UserOrder;
import com.DAO.IOrderDAO;
import com.JDBCUtil.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements IOrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql;
    int result = 0;

    @Override
    public boolean doAddPlayMenOrder(PlayMenOrder playMenOrder) {
        boolean flag = false;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();
            // 获取预编译的数据库操作对象
            sql = "insert into t_play_with_order(order_num,playmen_name,game_name,price,num,all_price,con,playmen_id)" +
                    " values('" + playMenOrder.getOrder_num() + "','" + playMenOrder.getPlaymen_name() + "'," +
                    "'" + playMenOrder.getGame_name() + "','" + playMenOrder.getPrice() + "','" + playMenOrder.getNum() + "'," +
                    "'" + playMenOrder.getAll_price() + "','" + playMenOrder.getCondition() + "','" + playMenOrder.getPlaymen_id() +
                    "')";
            ps = conn.prepareStatement(sql);
            // 执行SQL语句
            result = ps.executeUpdate();
            if (result > 0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.close(conn,ps,null);
        }
        return flag;
    }

    @Override
    public List<PlayMenOrder> doGetPlayMenOrder() {
        List<PlayMenOrder> playMenOrderList = new ArrayList<>();
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();
            // 获取预编译的数据库操作对象
            sql = "select id,order_num,playmen_name,game_name,price,num,all_price,con,playmen_id from t_play_with_order";
            ps = conn.prepareStatement(sql);
            // 执行SQL语句
            rs = ps.executeQuery();
            // 处理查询结果集
            while (rs.next()){
                PlayMenOrder playMenOrder = new PlayMenOrder();
                playMenOrder.setId(rs.getInt("id"));
                playMenOrder.setOrder_num(rs.getString("order_num"));
                playMenOrder.setPlaymen_name(rs.getString("playmen_name"));
                playMenOrder.setGame_name(rs.getString("game_name"));
                playMenOrder.setPrice(rs.getInt("price"));
                playMenOrder.setNum(rs.getInt("num"));
                playMenOrder.setAll_price(rs.getInt("all_price"));
                playMenOrder.setCondition(rs.getInt("con"));
                playMenOrder.setPlaymen_id(rs.getInt("playmen_id"));
                playMenOrderList.add(playMenOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.close(conn,ps,rs);
        }
        return playMenOrderList;
    }

    @Override
    public boolean doDeletePlayMenOrder(int id) {
        boolean flag = false;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();
            // 获取预编译的数据库操作对象
            sql = "delete from t_play_with_order where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            // 执行SQL语句
            result = ps.executeUpdate();
            if (result == 1) {
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.close(conn,ps,null);
        }
        return flag;
    }

    @Override
    public boolean doAddUserOrder(UserOrder userOrder) {
        boolean flag = false;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();
            // 获取预编译的数据库操作对象
            sql = "insert into t_user_order(order_num,playmen_name,game_name,price,num,all_price,con,user_id)" +
                    " values('" + userOrder.getOrder_num() + "','" + userOrder.getPlaymen_name() + "'," +
                    "'" + userOrder.getGame_name() + "','" + userOrder.getPrice() + "','" + userOrder.getNum() + "'," +
                    "'" + userOrder.getAll_price() + "','" + userOrder.getCondition() + "','" + userOrder.getUser_id() +
                    "')";
            ps = conn.prepareStatement(sql);
            // 执行SQL语句
            result = ps.executeUpdate();
            if (result > 0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.close(conn,ps,null);
        }
        return flag;
    }

    @Override
    public List<UserOrder> doGetUserOrder() {
        List<UserOrder> userOrderList = new ArrayList<>();
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();
            // 获取预编译的数据库操作对象
            sql = "select id,order_num,playmen_name,game_name,price,num,all_price,con,user_id from t_user_order";
            ps = conn.prepareStatement(sql);
            // 执行SQL语句
            rs=ps.executeQuery();
            // 处理查询结果集
            while (rs.next()){
                UserOrder userOrder = new UserOrder();
                userOrder.setId(rs.getInt("id"));
                userOrder.setOrder_num(rs.getString("order_num"));
                userOrder.setPlaymen_name(rs.getString("playmen_name"));
                userOrder.setGame_name(rs.getString("game_name"));
                userOrder.setPrice(rs.getInt("price"));
                userOrder.setNum(rs.getInt("num"));
                userOrder.setAll_price(rs.getInt("all_price"));
                userOrder.setCondition(rs.getInt("con"));
                userOrder.setUser_id(rs.getInt("user_id"));
                userOrderList.add(userOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.close(conn,ps,rs);
        }
        return userOrderList;
    }

    @Override
    public boolean doDeleteUserOrder(int id) {
        boolean flag = false;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();
            // 获取预编译的数据库操作对象
            sql = "delete from t_user_order where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            // 执行SQL语句
            result = ps.executeUpdate();
            if (result == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.close(conn,ps,null);
        }
        return flag;
    }
}
