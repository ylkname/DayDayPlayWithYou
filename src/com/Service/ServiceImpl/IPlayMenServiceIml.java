package com.Service.ServiceImpl;

import com.Bean.PlayMen;
import com.DAO.DAOImpl.IPlayMenDaoImpl;
import com.DAO.IPlayMenDAO;
import com.Service.IPlayMenService;

import java.sql.SQLException;

public class IPlayMenServiceIml implements IPlayMenService {
    IPlayMenDAO iPlayMenDAO=new IPlayMenDaoImpl();
    public boolean insert(PlayMen playMen) throws SQLException {
        boolean flag = iPlayMenDAO.insert(playMen);
        return flag;
    }
}
