package com.DAO;

import com.Bean.User;
import com.Bean.UserGift;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public User queryUserByUserName(String user_name) throws SQLException;
    public User queryUserById(int id) throws SQLException;
    public User queryUserByNameAndPas(String user_name,String user_password) throws SQLException;
    public boolean isExistUser(String user_name) throws SQLException;
    public int save(User user) throws SQLException;
    public int doMoney(int money,int id) throws SQLException;
    public  User selectoneuser(int uid);
    public  int login(String name, String pass);
    public int addGifts(UserGift user) throws SQLException;
    public int deleteGiftsById(Integer id) throws SQLException;
    public int updateGifts(UserGift user) throws SQLException;
    public UserGift queryGiftsById(Integer id) throws SQLException;
    public List<UserGift> queryGifts() throws SQLException;
    public List<UserGift> queryGiftsBytId(Integer id1, Integer id2) throws SQLException;
    Integer queryForPageTotalCount() throws SQLException;

    List<UserGift> queryForPageItems(int begin, int pageSize) throws SQLException;

    Integer queryForPageTotalCountByPrice(int min, int max) throws SQLException;

    List<UserGift> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) throws SQLException;
}
