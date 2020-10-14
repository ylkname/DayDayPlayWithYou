package com.Service.ServiceImpl;

import com.Bean.*;
import com.DAO.DAOImpl.AdminDaoImpl;
import com.DAO.IAdminDao;
import com.Service.IAdminService;

import java.util.List;
import java.util.Map;

public class IAdminServiceImpl implements IAdminService {
    private IAdminDao dao = new AdminDaoImpl();

    @Override
    public List<Applicant> findApply() {
        return dao.findApply();
    }

    @Override
    public void updateRole(Applicant applicant) {
        dao.updateRole(applicant);
    }

    @Override
    public void updateCondition(Applicant applicant) {
        dao.updateCondition(applicant);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public List<Admin> findAdmin() {
        return dao.findAdmin();
    }

    @Override
    public List<User> findUser() {
        return dao.findUser();
    }

    @Override
    public List<User> findPlayMen() {
        return dao.findPlayMen();
    }

    @Override
    public Admin login(Admin admin) {
        return dao.findAdminByAdminnameAndPassword(admin.getName(), admin.getPassword());
    }

    @Override
    public void addAdmin(Admin admin) {
        dao.addAdmin(admin);
    }

    @Override
    public void addPlayMen(PlayMen playMen) {
        dao.addPlayMen(playMen);
    }

    @Override
    public void delAdmin(String id) {
        dao.delAdmin(Integer.parseInt(id));
    }

    @Override
    public void delPlayMen(String id) {
        dao.delPlayMen(Integer.parseInt(id));
    }

    @Override
    public void delUser(String id) {
        dao.delUser(Integer.parseInt(id));
    }

    @Override
    public void delApply(String id) {
        dao.delApply(Integer.parseInt(id));
    }

    @Override
    public PageBean<User> findByPage(String currentPage, String rows, Map<String, String[]> condition) {
        int _currentPage = Integer.parseInt(currentPage);
        var _rows = Integer.parseInt(rows);
        if (_currentPage <= 0) {
            _currentPage = 1;
        }
        //1.创建空的PageBean对象
        PageBean<User> pageBean = new PageBean<User>();
        //2.设置参数
        pageBean.setCurrentPage(_currentPage);
        pageBean.setRows(_rows);
        //3.调用dao查询总记录数
        int _totalCount = dao.findTotalCount(condition);
        pageBean.setTotalCount(_totalCount);
        //4.调用dao查询list集合
        //4.1 计算开始的记录索引
        int start = (_currentPage - 1) * _rows;
        List<User> userList = dao.findByPage(start, _rows, condition);
        pageBean.setList(userList);
        //5.计算总页码
        int totalPage = (_totalCount % _rows) == 0 ? (_totalCount / _rows) : (_totalCount / _rows) + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
