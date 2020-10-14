package com.Service;

import com.Bean.*;

import java.util.List;
import java.util.Map;

/**
 * 管理员业务接口
 */
public interface IAdminService {
    public List<Applicant> findApply();

    public void updateRole(Applicant applicant);

    public void updateCondition(Applicant applicant);

    public void updateUser(User user);

    public List<Admin> findAdmin();

    public List<User> findUser();

    public List<User> findPlayMen();

    public Admin login(Admin admin);

    public void addAdmin(Admin admin);

    public void addPlayMen(PlayMen playMen);

    public void delAdmin(String id);

    public void delPlayMen(String id);

    public void delUser(String id);

    public void delApply(String id);

    public PageBean<User> findByPage(String currentPage, String rows, Map<String, String[]> condition);
}
