package com.Controller;

import com.Bean.PlayMen;
import com.Factory.BeanFactory;
import com.Service.ISearchService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SearchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String str=request.getParameter("action");
        if(str.contains("findALL")){
            findALL(request,response);
        }else if(str.contains("findPart")){
            findPart(request,response);
        }else if(str.contains("findRoom")){
            findRoom(request,response);
        }else if(str.contains("findSearchName")){
            findSearchName(request,response);
        }else if(str.contains("findSearchGrade")){
            findSearchGrade(request,response);
        }
    }

    /**
     * 模糊查询房间号
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        ISearchService iSearchService=BeanFactory.getInstance("SearchService");
        String str=request.getParameter("key");
        if(str!=null) {
            Gson gson=new Gson();
            List<PlayMen> list = iSearchService.getRoom(str);
            String str1 = gson.toJson(list);
            response.getWriter().print(str1);
        }
    }

    /**
     * 返回所有的陪玩信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findALL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISearchService iSearchService=BeanFactory.getInstance("SearchService");
        Gson gson=new Gson();
        List<PlayMen> list=iSearchService.getPlay("",0);
        String str=gson.toJson(list);
        response.getWriter().write(str);
    }

    /**
     * 返回一个陪玩的信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findPart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISearchService iSearchService=BeanFactory.getInstance("SearchService");
        Gson gson=new Gson();
        String str=request.getParameter("key");
        PlayMen playMen=iSearchService.getOnePlayMen(str);
        String s=gson.toJson(playMen);
        response.getWriter().write(s);
    }

    /**
     * 根据游戏名去查找
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findSearchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISearchService iSearchService=BeanFactory.getInstance("SearchService");
        Gson gson=new Gson();
        String str=request.getParameter("key");
        if(str.contains("不限")){
            List<PlayMen> list=iSearchService.getPlay("",0);
            String str1=gson.toJson(list);
            response.getWriter().write(str1);
        }else {
            List<PlayMen> list=iSearchService.getPlay(str,1);
            String str1=gson.toJson(list);
            response.getWriter().write(str1);
        }
    }

    /**
     *根据游戏段位去查找
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findSearchGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISearchService iSearchService=BeanFactory.getInstance("SearchService");
        Gson gson=new Gson();
        String str=request.getParameter("key");
        if(str.contains("不限")){
            List<PlayMen> list=iSearchService.getPlay("",0);
            String str1=gson.toJson(list);
            response.getWriter().write(str1);
        }else {
            List<PlayMen> list=iSearchService.getPlay(str,2);
            String str1=gson.toJson(list);
            response.getWriter().write(str1);
        }
    }
}
