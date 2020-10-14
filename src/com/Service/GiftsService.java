package com.Service;

import com.Bean.Gifts;
import com.Bean.Page;

import java.sql.SQLException;
import java.util.List;

public interface GiftsService {
    public int addGifts(Gifts gifts) throws SQLException;
    public int deleteGiftsById(Integer id) throws SQLException;
    public int updateGifts(Gifts gifts) throws SQLException;
    public Gifts queryGiftsById(Integer id) throws SQLException;
    public List<Gifts> queryGifts() throws SQLException;
    Page<Gifts> page(int pageNo, int pageSize) throws SQLException;

    Page<Gifts> pageByPrice(int pageNo, int pageSize, int min, int max) throws SQLException;
}
