package com.Controller;

import com.Bean.Chat;
import com.Bean.User;
import com.Service.ServiceImpl.ChatServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/selectChat","/addChat"})
public class ChatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String serlvetPath = request.getServletPath();
        if (serlvetPath.contains("/selectChat")) {
            selectMess(request,response);
        }else if (serlvetPath.contains("/addChat")){
            sendMess(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void sendMess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //获取当前用户信息
        User user = new User();
        if(session.getAttribute("user")==null) {
            response.sendRedirect("login.jsp");
            return;
        }
        user = (User)session.getAttribute("user");
        int senderid = user.getId();
        //接收表单数据
        String content = request.getParameter("sendcontent");
        int receiverid = Integer.parseInt(request.getParameter("tid"));

        //DAO
        ChatServiceImpl service = new ChatServiceImpl();
        int end = service.send(senderid,receiverid,content);
        //查询发送者与接收者所有留言信息
        ArrayList<Chat> chats = new ArrayList<>();
        chats = service.selectUserMessage(senderid,receiverid);
        request.setAttribute("user",user);
        request.setAttribute("chats", chats);
//        request.getRequestDispatcher("chat.jsp").forward(request, response);
        selectMess(request,response);
    }

    private void selectMess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session=request.getSession();
        //获取当前用户信息
        User user = new User();
//        if(session.getAttribute("user")==null) {
//            response.sendRedirect("/DayDayPlay/public/page/login.jsp");
//            return;
//        }
        int id=(int)session.getAttribute("id");
        user = (User)session.getAttribute("user");
        int senderid = id;
        int receiverid = Integer.parseInt(request.getParameter("tid"));
        ChatServiceImpl service = new ChatServiceImpl();
        //查询发送者与接收者所有留言信息
        ArrayList<Chat> chats = new ArrayList<>();
        chats = service.selectUserMessage(senderid,receiverid);
        request.setAttribute("user",user);
        request.setAttribute("chats", chats);
        request.getRequestDispatcher("/public/page/chat.jsp").forward(request, response);
    }
}
