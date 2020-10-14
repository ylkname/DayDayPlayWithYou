package com.DAO.DAOImpl;
import com.Bean.AdminUser;
import com.Bean.User;
import com.JDBCUtil.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public  class UserBase{
        //修改数据
        private QueryRunner query=new QueryRunner(JDBCUtils.getDataSource());
        public int update(String sql,Object...args) throws SQLException {
            Connection con=JDBCUtils.getConnection();
            try {
                return query.update(sql,args);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                JDBCUtils.close(con);
            }
            return -1;
        }
        //查询一条数据
        public User queryone(String sql, Object...args) throws SQLException {
            Connection con=JDBCUtils.getConnection();
            try {
                User user=query.query(sql,new BeanHandler<User>(User.class),args);
                return user ;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                JDBCUtils.close(con);
            }
            return null;
        }
        //查询多条数据
        public AdminUser queryAdmin(String sql, Object...args) throws SQLException {
            Connection con=JDBCUtils.getConnection();
            try {
               AdminUser adminUser=query.query(sql,new BeanHandler<AdminUser>(AdminUser.class),args);
               return adminUser;

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                JDBCUtils.close(con);
            }
            return null;
        }
        public List<User> queryAll(String sql) throws SQLException {
            Connection con=JDBCUtils.getConnection();
            try {
                List<User> list=query.query(sql,new BeanListHandler<User>(User.class));
                return list;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                JDBCUtils.close(con);
            }
            return null;
        }
    }

