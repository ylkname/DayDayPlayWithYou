package com.Test;

import com.Bean.PlayMen;
import com.DAO.ISearchDAO;
import com.DAO.IUserDAO;
import com.Factory.BeanFactory;
import com.Service.ISearchService;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void test1(){
        System.out.println(BeanFactory.getInstance("UserDAO") instanceof IUserDAO);
    }

    @Test
    public void test2(){
        ISearchService iSearchService=BeanFactory.getInstance("SearchService");
        List<PlayMen> list=iSearchService.getRoom("9");
        for (PlayMen playMen:list){
            System.out.println(playMen.getRoom_id());
        }
    }
    @Test
    public void test3(){
        ISearchDAO iSearchDAO =BeanFactory.getInstance("SearchDAO");
        List<PlayMen> list=iSearchDAO.findPlayMen("绝地求生");
        for(PlayMen playMen:list){
            System.out.print(playMen.getName()+"、"+playMen.getSex()+"、"+playMen.getGame_name()+"、"+playMen.getGame_grade()+"、"+playMen.getPrice());
            System.out.println();
        }
    }
    @Test
    public void test4(){
        ISearchDAO iSearchDAO =BeanFactory.getInstance("SearchDAO");
        List<PlayMen> list=iSearchDAO.findRoom("1");
        Gson gson=new Gson();
        String str1=gson.toJson(list);
        System.out.println(str1);
        for(PlayMen playMen:list){
            System.out.print(playMen.getName()+"、"+playMen.getSex()+"、"+playMen.getGame_name()+"、"+playMen.getGame_grade()+"、"+playMen.getPrice());
            System.out.println();
        }
    }
    @Test
    public void test5(){
        ISearchService iSearchService=BeanFactory.getInstance("SearchService");
        System.out.println(iSearchService.getOnePlayMen("9232"));
    }
    @Test
    public void test6(){
        ISearchService iSearchService=BeanFactory.getInstance("SearchService");
        System.out.println(iSearchService.getPlayMenPrice());
    }
    @Test
    public void test7(){
        ISearchService iSearchService=BeanFactory.getInstance("SearchService");
        System.out.println(iSearchService.getPlay("萌新",2));
    }
}
