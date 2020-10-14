package com.DAO;

import com.Bean.PlayMen;

import java.sql.SQLException;

public interface IPlayMenDAO {
    public boolean insert(PlayMen playMen) throws SQLException;
}
