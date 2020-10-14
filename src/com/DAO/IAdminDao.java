package com.DAO;

import com.Bean.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IAdminDao {
    public AdminUser queryUserAndPas(String adminname, String password) throws SQLException;//查询管理员是否存在
    public Admin findAdminByAdminnameAndPassword(String adminname, String password);

    public List<Applicant> findApply();

    public List<Admin> findAdmin();

    public List<User> findUser();

    public List<User> findPlayMen();

    public void updateRole(Applicant applicant);

    public void updateCondition(Applicant applicant);

    public void updateUser(User user);

    public void addAdmin(Admin admin);

    public void addPlayMen(PlayMen playMen);

    public void delAdmin(int id);

    public void delPlayMen(int id);

    public void delUser(int id);

    public void delApply(int id);

    public int findTotalCount(Map<String, String[]> condition);

    public List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}

