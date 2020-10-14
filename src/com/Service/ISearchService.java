package com.Service;

import com.Bean.PlayMen;

import java.util.List;

public interface ISearchService {
    public List<PlayMen> getRoom(String str);
    public List<PlayMen> getPlay(String str1,int i);
    public PlayMen getOnePlayMen(String str);
    public List<PlayMen> getPlayMenPrice();
}
