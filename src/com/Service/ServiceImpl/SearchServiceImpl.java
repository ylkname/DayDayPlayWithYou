package com.Service.ServiceImpl;

import com.Bean.PlayMen;
import com.DAO.ISearchDAO;
import com.Factory.BeanFactory;
import com.Service.ISearchService;
import java.util.List;

public class SearchServiceImpl implements ISearchService {
    /**
     * 根据输入的词，经行模糊查询
     * @param str 关键词，根据关键词进行模糊查询
     * @return 返回查询到的结果
     */
    @Override
    public List<PlayMen> getRoom(String str) {
        ISearchDAO isearchDAO=BeanFactory.getInstance("SearchDAO");
        return isearchDAO.findRoom(str);
    }


    /**
     * 根据指定的内容查询结果
     * @param str1 游戏名
     * @param i 查询的类型，1表示只查询游戏名，2表示游戏名和游戏段位一起查询
     * @return 返回查询结果
     */
    @Override
    public List<PlayMen> getPlay(String str1,int i) {
        ISearchDAO isearchDAO=BeanFactory.getInstance("SearchDAO");
        if(i==0){
            List<PlayMen> list=isearchDAO.findPlayMen();
            return list;
        }else if(i==1){
            List<PlayMen> list=isearchDAO.findPlayMen(str1);
            return list;
        }else if(i==2){
            List<PlayMen> list=isearchDAO.findGame(str1);
            return list;
        }
        return null;
    }

    /**
     * 根据房间号查找对应的陪玩
     * @param str 房间号
     * @return 返回陪玩信息
     */
    @Override
    public PlayMen getOnePlayMen(String str) {
        ISearchDAO isearchDAO=BeanFactory.getInstance("SearchDAO");
        return  isearchDAO.findOnePlayMen(str);
    }
    @Override
    public List<PlayMen> getPlayMenPrice(){
        ISearchDAO iSearchDAO=BeanFactory.getInstance("SearchDAO");
        List<PlayMen> list=iSearchDAO.findSort();
        return list;
    }
}
