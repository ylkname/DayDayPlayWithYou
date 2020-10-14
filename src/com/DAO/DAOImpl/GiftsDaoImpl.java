package com.DAO.DAOImpl;

import com.DAO.IGiftDAO;
import com.Bean.Gifts;
import com.JDBCUtil.BaseDao;

import java.sql.SQLException;
import java.util.List;

public class GiftsDaoImpl extends BaseDao implements IGiftDAO {
    public GiftsDaoImpl(){

    }

    @Override
    public int addGifts(Gifts gifts) throws SQLException {
        String sql="insert into gifts(`Name`,`Price`,`photo`) values(?,?,?)";
        return update(sql,gifts.getName(),gifts.getPrice(),gifts.getPhoto());
    }

    @Override
    public int deleteGiftsById(Integer id) throws SQLException {
        String sql="delete from gifts where Id=?";
        return update(sql,id);
    }

    @Override
    public int updateGifts(Gifts gifts) throws SQLException {
        String sql="update gifts set `Name`=?,`Price`=?,`photo`=?  where Id=?";
        return update(sql,gifts.getName(),gifts.getPrice(),gifts.getPhoto(),gifts.getId());
    }

    @Override
    public Gifts queryGiftsById(Integer id) throws SQLException {
        String sql="select * from gifts where Id=?";
        return queryForOne(Gifts.class,sql,id);
    }

    @Override
    public List<Gifts> queryGifts() throws SQLException {
        String sql="select * from gifts";
        return queryForList(Gifts.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() throws SQLException {
        String sql="select count(*) from gifts";
        Number count= (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Gifts> queryForPageItems(int begin, int pageSize) throws SQLException {
        String sql="select *from gifts limit ?,?";
        return queryForList(Gifts.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) throws SQLException {
        String sql="select count(*) from gifts where price between ? and ?";
        Number count= (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Gifts> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) throws SQLException {
        String sql="select *from gifts where price between ? and ? order by price limit ?,?";
        return queryForList(Gifts.class,sql,min,max,begin,pageSize);
    }
}
