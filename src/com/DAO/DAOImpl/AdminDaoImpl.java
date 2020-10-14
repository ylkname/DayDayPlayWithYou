package com.DAO.DAOImpl;

import com.Bean.*;
import com.DAO.IAdminDao;
import com.JDBCUtil.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdminDaoImpl extends UserBase implements IAdminDao {
    @Override
    public AdminUser queryUserAndPas(String adminname, String password) throws SQLException {
        String sql="select *from t_admin where adminname=? and password=?";
        AdminUser admin = queryAdmin(sql, adminname, password);
        return admin;
    }
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Admin findAdminByAdminnameAndPassword(String adminname, String password) {
        try {
            String sql = "select * from t_admin where adminname = ? and password = ? ";
            Admin admin = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), adminname, password);
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Applicant> findApply() {
        String sql = "select * from t_applicant ";
        List<Applicant> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Applicant>(Applicant.class));
        return list;
    }

    @Override
    public List<Admin> findAdmin() {
        String sql = "select * from t_user ";
        List<Admin> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Admin>(Admin.class));
        return list;
    }

    @Override
    public List<User> findUser() {
        String sql = "select * from t_user where role = 1";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public List<User> findPlayMen() {
        String sql = "select * from t_user where role = 2";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public void updateRole(Applicant applicant) {
        String sql = "";
        if (applicant.getRole() == 1) {
            sql = "update t_user set role = 2 where id = ? ";
        }
        if (applicant.getRole() == 2) {
            sql = "update t_user set role = 1 where id = ? ";
        }
        jdbcTemplate.update(sql, applicant.getId());
    }

    @Override
    public void updateCondition(Applicant applicant) {
        String sql = "";
        if (applicant.getRole() == 1) {
            sql = "update t_user set condition = 2 where id = ? ";
        }
        if (applicant.getRole() == 2) {
            sql = "update t_user set condition = 1 where id = ? ";
        }
        jdbcTemplate.update(sql, applicant.getId());
    }

    @Override
    public void updateUser(User user) {
        //1.定义sql
        String sql = "update t_user set user_name = ?,user_password = ?,name = ?,photo = ?,QQ_num = ?,money = ?,phone = ? where id = ? ";
        //执行sql
        jdbcTemplate.update(sql, user.getUser_name(), user.getUser_password(), user.getName(), user.getPhoto(), user.getQq_num(), user.getMoney(), user.getPhone(), user.getId());
    }

    @Override
    public void addAdmin(Admin admin) {
        String sql = "insert into t_admin values(null,?,?) ";
        jdbcTemplate.update(sql, admin.getName(), admin.getPassword());
    }

    @Override
    public void addPlayMen(PlayMen playMen) {
        String sql = "insert into t_play_with values(null,?,?,?,?,?,?,?,?) ";
        jdbcTemplate.update(sql, playMen.getSex(), playMen.getID_name(), playMen.getID_num(), playMen.getGame_name(), playMen.getGame_grade(), playMen.getAPP_photo(), playMen.getPrice(), playMen.getRoom_id());
    }

    @Override
    public void delAdmin(int id) {
        String sql = "delete from t_admin where id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void delPlayMen(int id) {
        String sql = "delete from t_play_with where id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void delUser(int id) {
        String sql = "delete from t_user where id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void delApply(int id) {
        String sql = "delete from t_applicant where id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        ArrayList<Object> arrayList = new ArrayList<>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !("".equals(value))) {//有值
                sb.append("and" + key + "like ? ");
                arrayList.add("%" + value + "%");// ? 条件的值
            }
        }
        return jdbcTemplate.queryForObject(sql, Integer.class, arrayList.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        ArrayList<Object> arrayList = new ArrayList<>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !("".equals(value))) {//有值
                sb.append("and" + key + "like ? ");
                arrayList.add("%" + value + "%");// ? 条件的值
            }
        }
        //添加分页查询
        sb.append(" limit ? , ? ");
        //添加分页查询参数值
        arrayList.add(start);
        arrayList.add(rows);
        sql = sb.toString();
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), arrayList.toArray());
    }
}
