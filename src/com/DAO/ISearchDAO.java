package com.DAO;

import com.Bean.PlayMen;
import com.Bean.User;

import java.util.List;

public interface ISearchDAO {
    public List<PlayMen> findPlayMen();
    public List<PlayMen> findRoom(String str);
    public List<PlayMen> findPlayMen(String str1);
    public List<PlayMen> findGame(String str1);
    public PlayMen findOnePlayMen(String str);
    public List<PlayMen> findSort();
}
