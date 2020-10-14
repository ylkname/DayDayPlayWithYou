package com.Service.ServiceImpl;

import com.Bean.*;
import com.DAO.DAOImpl.UserDAOImpl;
import com.DAO.IAdminDao;
import com.DAO.IUserDAO;
import com.Service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {

    private IUserDAO userDAO;
    private IAdminDao adminDao;

    public UserServiceImpl() {

    }

    public UserServiceImpl(IUserDAO userDAO, IAdminDao adminDao) {
        this.userDAO = userDAO;
        this.adminDao = adminDao;
    }

    @Override
    public User queryUserById(int id) throws SQLException {
        User user = userDAO.queryUserById(id);
        return user;
    }

    @Override
    public User login(String user_name, String password) throws SQLException {
        User user = userDAO.queryUserByNameAndPas(user_name, password);
        return user;
    }

    @Override
    public int resign(User user) throws SQLException {
        int num = userDAO.save(user);
        return num;
    }

    @Override
    public boolean iExistUser(String user_name) throws SQLException {
        User user = userDAO.queryUserByUserName(user_name);
        if (user == null) {
            return true;
        } else return false;
    }

    @Override
    public AdminUser adminLogin(String adminName, String adminPassword) throws SQLException {
        AdminUser admin = adminDao.queryUserAndPas(adminName, adminPassword);
        return admin;
    }

    @Override
    public int addMoney(int money, int id) throws SQLException {
        int num = userDAO.doMoney(money, id);
        return num;
    }

    @Override
    public UserOrder createUserOrder(UserOrder userOrder) {
        return userOrder;
    }

    @Override
    public PlayMenOrder createPlayMenOrder(PlayMenOrder playMenOrder) {
        return playMenOrder;
    }

    /**
     * 带参数，通过uid查询用户信息
     *
     * @param uid-用户id
     * @return
     */
    public User selectoneuser(int uid) {
        IUserDAO iUserDAO= new UserDAOImpl();
        return iUserDAO.selectoneuser(uid);
    }


//    @Override
//    public int addGifts(UserGift user) throws SQLException {
//        return userDao.addGifts(user);
//    }
//
//    @Override
//    public int deleteGiftsById(Integer id) throws SQLException {
//        return userDao.deleteGiftsById(id);
//    }
//
//    @Override
//    public int updateGifts(UserGift user) throws SQLException {
//        return userDao.updateGifts(user);
//    }
//
//    @Override
//    public UserGift queryGiftsById(Integer id) throws SQLException {
//        return userDao.queryGiftsById(id);
//    }
//
//    @Override
//    public List<UserGift> queryGifts() throws SQLException {
//        return userDao.queryGifts();
//    }
//
//    @Override
//    public List<UserGift> queryGiftsBytId(Integer id1, Integer id2) throws SQLException {
//        return userDao.queryGiftsBytId(id1, id2);
//    }
//
//    @Override
//    public Page<UserGift> page(int pageNo, int pageSize) throws SQLException {
//        Page<UserGift> page = new Page<UserGift>();
//        //设置每页显示的数量
//        page.setPageSize(pageSize);
//        //求总记录数
//        Integer pageTotalCount = userDao.queryForPageTotalCount();
//        //设置总记录数
//        page.setPageTotalCount(pageTotalCount);
//        //求总的页码
//        Integer pageTotal = pageTotalCount / pageSize;
//        if (pageTotalCount % pageSize > 0) {
//            pageTotal++;
//        }
//        //设置总页码
//        page.setPageTotal(pageTotal);
//        //设置当前页码
//        page.setPageNo(pageNo);
//        //求当前页数据的起始索引
//        int begin = (page.getPageNo() - 1) * pageSize;
//        //求当前页数据
//        List<UserGift> items = userDao.queryForPageItems(begin, pageSize);
//        //设置当前页数据
//        page.setItems(items);
//
//        return page;
//    }
}
