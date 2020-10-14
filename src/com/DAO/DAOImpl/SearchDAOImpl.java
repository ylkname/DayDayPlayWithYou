package com.DAO.DAOImpl;

import com.Bean.PlayMen;
import com.Bean.User;
import com.DAO.ISearchDAO;
import com.JDBCUtil.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDAOImpl implements ISearchDAO {
    /**
     * 根据游戏名字，来查找相对应的陪玩信息
     * @param str1 游戏名
     * @return 返回查找到的结果
     */
    @Override
    public List<PlayMen> findPlayMen(String str1) {
        List<PlayMen> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            conn= JDBCUtils.getConnection();
            String sql="select name,sex,Game_name,Game_grade,price,Room_id,App_photo from t_play_with where Game_name=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,str1);
            rs=pst.executeQuery();
            while(rs.next()){
                PlayMen playMen=new PlayMen();
                playMen.setName(rs.getString(1));
                playMen.setSex(rs.getString(2));
                playMen.setGame_name(rs.getString(3));
                playMen.setGame_grade(rs.getString(4));
                playMen.setPrice(rs.getDouble(5));
                playMen.setRoom_id(rs.getString(6));
                playMen.setAPP_photo(rs.getString(7));
                list.add(playMen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pst,rs);
        }
        return list;
    }

    /**
     * 根据游戏名和游戏段位查询相应的陪玩信息
     * @param str1 游戏名
     * @return 返回查询到的结果
     */
    @Override
    public List<PlayMen> findGame(String str1) {
        List<PlayMen> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            conn=JDBCUtils.getConnection();
            String sql="select name,sex,Game_name,Game_grade,price,Room_id,App_photo from t_play_with where Game_grade= ? ";
            pst=conn.prepareStatement(sql);
            pst.setString(1,str1);
            rs=pst.executeQuery();
            while(rs.next()) {
                PlayMen playMen = new PlayMen();
                playMen.setName(rs.getString(1));
                playMen.setSex(rs.getString(2));
                playMen.setGame_name(rs.getString(3));
                playMen.setGame_grade(rs.getString(4));
                playMen.setPrice(rs.getDouble(5));
                playMen.setRoom_id(rs.getString(6));
                playMen.setAPP_photo(rs.getString(7));
                list.add(playMen);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pst,rs);
        }
        return list;
    }

    /**
     * 返回所有陪玩信息
     * @return 返回所有陪玩的信息
     */
    @Override
    public List<PlayMen> findPlayMen() {
        List<PlayMen> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            conn= JDBCUtils.getConnection();
            String sql="select name,sex,Game_name,Game_grade,price,Room_id,App_photo from t_play_with";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                PlayMen playMen=new PlayMen();
                playMen.setName(rs.getString(1));
                playMen.setSex(rs.getString(2));
                playMen.setGame_name(rs.getString(3));
                playMen.setGame_grade(rs.getString(4));
                playMen.setPrice(rs.getDouble(5));
                playMen.setRoom_id(rs.getString(6));
                playMen.setAPP_photo(rs.getString(7));
                list.add(playMen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pst,rs);
        }
        return list;
    }

    /**
     * 根据传入的值，去陪玩表中查询相似的信息，并返回信息类似的信息
     * @param str 根据str的值，进行模糊查询
     * @return 返回模糊查询后的信息。
     */
    @Override
    public List<PlayMen> findRoom(String str) {
        List<PlayMen> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            conn= JDBCUtils.getConnection();
            String sql="select Room_id from t_play_with where Room_id like '"+str+"%' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                PlayMen playMen=new PlayMen();
                playMen.setRoom_id(rs.getString(1));
                list.add(playMen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pst,rs);
        }
        return list;
    }

    @Override
    public PlayMen findOnePlayMen(String str) {
        PlayMen playMen=null;
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            conn= JDBCUtils.getConnection();
            String sql="select name,sex,Game_name,Game_grade,price,Room_id,App_photo from t_play_with where Room_id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,str);
            rs=pst.executeQuery();
            if(rs.next()){
                playMen=new PlayMen();
                playMen.setName(rs.getString(1));
                playMen.setSex(rs.getString(2));
                playMen.setGame_name(rs.getString(3));
                playMen.setGame_grade(rs.getString(4));
                playMen.setPrice(rs.getDouble(5));
                playMen.setRoom_id(rs.getString(6));
                playMen.setAPP_photo(rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pst,rs);
        }
        return playMen;
    }

    @Override
    public List<PlayMen> findSort() {
        List<PlayMen> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            conn= JDBCUtils.getConnection();
            String sql="select name,sex,Game_name,Game_grade,price,Room_id,App_photo from t_play_with t order by t.price ASC";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                PlayMen playMen=new PlayMen();
                playMen.setName(rs.getString(1));
                playMen.setSex(rs.getString(2));
                playMen.setGame_name(rs.getString(3));
                playMen.setGame_grade(rs.getString(4));
                playMen.setPrice(rs.getDouble(5));
                playMen.setRoom_id(rs.getString(6));
                playMen.setAPP_photo(rs.getString(7));
                list.add(playMen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pst,rs);
        }
        return list;
    }
}
