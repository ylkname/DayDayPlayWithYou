package com.DAO.DAOImpl;

import com.Bean.PlayMen;
import com.DAO.IPlayMenDAO;

import java.sql.SQLException;

public class IPlayMenDaoImpl extends UserBase implements IPlayMenDAO  {
    @Override
    public boolean insert(PlayMen playMen) throws SQLException {
        String sql="insert into t_play_with values(?,?,?,?,?,?,?,?,?)";
        int i=1;
        return (update(sql,5,playMen.getSex(),playMen.getID_name(),playMen.getID_num(),playMen.getGame_name()
        ,playMen.getGame_grade(),playMen.getAPP_photo(),playMen.getPrice(),88)>0?true:false);
    }
}
