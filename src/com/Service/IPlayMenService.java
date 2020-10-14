package com.Service;

import com.Bean.PlayMen;

import java.sql.SQLException;

public interface IPlayMenService {

    public boolean insert(PlayMen playMen) throws SQLException;
}
