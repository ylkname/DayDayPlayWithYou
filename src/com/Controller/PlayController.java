package com.Controller;

import com.Bean.JsonResult;
import com.Bean.PlayMen;
import com.Service.IPlayMenService;
import com.Service.ServiceImpl.IPlayMenServiceIml;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

@WebServlet(name = "playController",urlPatterns = {"*.io"})
public class PlayController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath=req.getServletPath();
        if (servletPath.contains("notice.io")){
            notice(req,resp);
        }
        if(servletPath.contains("play.io")){
            try {
                play(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    protected void notice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String ifNotice=req.getParameter("val");
    }


    protected void play(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String sex=req.getParameter("sex");
        String id_name=req.getParameter("id_name");
        String id_card=req.getParameter("id_card");
        String app_photo=req.getParameter("app_photo");
        String tutor_box=req.getParameter("tutor_box");
        String tutor_level=req.getParameter("tutor_level");
        String price=req.getParameter("price");
        Random random=new Random();
        int i= random.nextInt(9999)+1000;
        String Room_id=String.valueOf(i);
        IPlayMenService service=new IPlayMenServiceIml();
        PlayMen playMen=new PlayMen(sex,id_name,id_card,tutor_box,tutor_level,app_photo, Double.parseDouble(price),Room_id);
        Gson gson=new Gson();
        JsonResult jr=new JsonResult();
        boolean insert = service.insert(playMen);
        if(insert==true){
            System.out.println("注册成功");
            jr.setResult("1000");
            jr.setMsg("申请成功");

        }else {
            System.out.println("注册失败");
            jr.setResult("1001");
            jr.setMsg("申请失败");
        }
    }
}
