package com.DAO;

import com.Bean.Gifts;

import java.sql.SQLException;
import java.util.List;

public interface IGiftDAO {
    public int addGifts(Gifts gifts) throws SQLException;
    public int deleteGiftsById(Integer id) throws SQLException;
    public int updateGifts(Gifts gifts) throws SQLException;
    public Gifts queryGiftsById(Integer id) throws SQLException;
    public List<Gifts> queryGifts() throws SQLException;
    Integer queryForPageTotalCount() throws SQLException;

    List<Gifts> queryForPageItems(int begin, int pageSize) throws SQLException;

    Integer queryForPageTotalCountByPrice(int min, int max) throws SQLException;

    List<Gifts> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) throws SQLException;
}
