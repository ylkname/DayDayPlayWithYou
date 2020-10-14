package com.Service;

import com.Bean.*;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {

    /**
     * 生成用户订单
     * @param userOrder
     */
    default UserOrder createUserOrder(UserOrder userOrder){
        return null;
    };

    /**
     * 生成配玩订单
     * @param playMenOrder
     */
    default PlayMenOrder createPlayMenOrder(PlayMenOrder playMenOrder){
        return null;
    };
    public User queryUserById(int id) throws SQLException;
    public User login(String user_name,String password) throws SQLException;
    public int resign(User user) throws SQLException;
    public boolean iExistUser(String user_name) throws SQLException;
    public AdminUser adminLogin(String adminName, String adminPassword) throws SQLException;
    public int addMoney(int money,int id) throws SQLException;
    public User selectoneuser(int uid);


//    public int addGifts(UserGift user) throws SQLException;
//    public int deleteGiftsById(Integer id) throws SQLException;
//    public int updateGifts(UserGift user) throws SQLException;
//    public UserGift queryGiftsById(Integer id) throws SQLException;
//    public List<UserGift> queryGifts() throws SQLException;
//    public List<UserGift> queryGiftsBytId(Integer id1, Integer id2) throws SQLException;
//    Page<UserGift> page(int pageNo, int pageSize) throws SQLException;
}