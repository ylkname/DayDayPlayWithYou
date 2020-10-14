package com.DAO.DAOImpl;

import com.Bean.User;
import com.Bean.UserGift;
import com.DAO.IUserDAO;
import com.JDBCUtil.BaseDao;
import com.JDBCUtil.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl extends UserBase implements  IUserDAO {
    BaseDao baseDao=new BaseDao();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql;
    int result = 0;


    @Override
    public User queryUserById(int id) throws SQLException {
        String sql="select *from t_user where id=?";
        return queryone(sql,id);
    }

    @Override
    public User queryUserByUserName(String user_name) throws SQLException {
        String sql="select *from t_user where user_name=?";
        return queryone(sql,user_name);
    }

    @Override
    public User queryUserByNameAndPas(String user_name, String user_password) throws SQLException {
        String sql="select *from t_user where user_name=? and user_password=?";
        return queryone(sql,user_name,user_password);
    }

    @Override
    public boolean isExistUser(String user_name) throws SQLException {
        if(queryUserByUserName(user_name)==null){
            return true;
        }else return false;
    }

    @Override
    public int save(User user) throws SQLException {
        String sql="insert into t_user values(?,?,?,?,?,?,?,?,?,?)" ;
        int i=1;
        return update(sql,null,user.getUser_name(),user.getUser_password(),user.getName(),"photo",user.getUser_name(),
                user.getPhone(),0,1,1);

    }
    //操作
    @Override
    public int doMoney(int money,int id) throws SQLException {
        String sql="update t_user set money=money+? where id=?";
        return update(sql,money,id);
    }

    /**
     * 带参数，通过uid查询用户信息
     * @param uid-用户id
     * @return
     */
    public User selectoneuser(int uid){
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        String sql="SELECT * FROM t_user WHERE id = ?";
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uid);
            res = ps.executeQuery();
            if(res.next()) {
                user = new User();
                user.setId(res.getInt("id"));
                user.setUser_name(res.getString("user_name"));
                user.setUser_password(res.getString("user_password"));
                user.setPhoto(res.getString("photo"));
                user.setQq_num(res.getString("QQ_num"));
                user.setPhone(res.getString("phone"));
                user.setMoney(res.getInt("money"));
                user.setRole(res.getInt("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(res!=null)res.close();
                if(ps!=null)ps.close();
                if(conn!=null)conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return user;
    }
    /**
     * 登录
     * @param name
     * @param pass
     * @return 返回用户id
     */
    public int login(String name, String pass) {
        int userid = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        String sql = "SELECT id FROM t_user WHERE user_name = ? AND user_password = ?";
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            res = ps.executeQuery();
            if(res.next()) {
                userid = res.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(res!=null)res.close();
                if(ps!=null)ps.close();
                if(conn!=null)conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return userid;
    }

    @Override
    public int addGifts(UserGift user) throws SQLException {
        String sql="insert into gifts_to(`User_id`,`Gift_id`,`Gift_num`,`Playmen_id`,`date`) values(?,?,?,?,?)";
        return update(sql,user.getUser_id(),user.getGift_id(),user.getGift_num(),user.getPlaymen_id(),user.getDate());
    }
    @Override
    public int deleteGiftsById(Integer id) throws SQLException {
        String sql="delete from gifts_to where Id=?";
        return update(sql,id);
    }

    @Override
    public int updateGifts(UserGift user) throws SQLException {
        String sql="update gifts_to set `User_id`=?,`Gift_id`=?,`Gift_num`=?,`Playmen_id`=?,`date`=? where Id=?";
        return update(sql,user.getUser_id(),user.getGift_id(),user.getGift_num(),user.getPlaymen_id(),user.getDate(),user.getId());
    }

    @Override
    public UserGift queryGiftsById(Integer id) throws SQLException {
        String sql="select * from gifts_to where Id=?";
        return baseDao.queryForOne(UserGift.class,sql,id);
    }
    @Override
    public List<UserGift> queryGifts() throws SQLException {
        String sql="select * from gifts_to";
        return baseDao.queryForList(UserGift.class,sql);
    }

    @Override
    public List<UserGift> queryGiftsBytId(Integer id1, Integer id2) throws SQLException {
        String sql="select *from gifts_to where user_id=?&&playmen_id=?";
        return baseDao.queryForList(UserGift.class,sql,id1,id2);
    }

    @Override
    public Integer queryForPageTotalCount() throws SQLException {
        String sql="select count(*) from gifts_to";
        Number count= (Number) baseDao.queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<UserGift> queryForPageItems(int begin, int pageSize) throws SQLException {
        String sql="select *from gifts_to limit ?,?";
        return baseDao.queryForList(UserGift.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) throws SQLException {
        String sql="select count(*) from gifts_to where price between ? and ?";
        Number count= (Number) baseDao.queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<UserGift> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) throws SQLException {
        String sql="select *from gifts_to where price between ? and ? order by price limit ?,?";
        return baseDao.queryForList(UserGift.class,sql,min,max,begin,pageSize);
    }
}

