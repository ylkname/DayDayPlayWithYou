package com.Controller;

import com.Bean.Message;
import com.Bean.User;
import com.Service.ServiceImpl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("*.action")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String serlvetPath = request.getServletPath();
        if (serlvetPath.contains("addmessageby.action")) {
            addmessageby(request,response);
        }else if (serlvetPath.contains("messageuserreply.action")){
            messageuserreply(request,response);
        }else if (serlvetPath.contains("selectmessage.action")){
            selectmessage(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void addmessageby(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        //获取当前用户信息
        User user = new User();
        int id=(int)session.getAttribute("id");
        user = (User)session.getAttribute("user");
        if(session.getAttribute("user")==null) {
            response.sendRedirect("login.jsp");
            return;
        }
        int wid = 0,gid = 0;
        wid = id;//当前用户id
        //接收数据
        //gid = Integer.parseInt(request.getParameter("gid"));//接收留言者的id
        gid=2;
        String content=request.getParameter("messagecontent");//留言内容
        //DAO
        MessageServiceImpl service = new MessageServiceImpl();
        int end = service.addmessage(wid, gid, content);
        //查询该用户所有留言信息
        ArrayList<Message> message = new ArrayList<>();
        message = service.SelectUserMessage(wid);
        request.setAttribute("messageinfo", message);
        selectmessage(request,response);
    }

    private void messageuserreply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session=request.getSession();
        //获取当前用户信息
        User user = new User();
        if(session.getAttribute("user")==null) {
            response.sendRedirect("login.jsp");
            return;
        }
        user = (User)session.getAttribute("user");
        int userid = user.getId();
        //接收表单数据
        String content = request.getParameter("replycontent");
        int msgid = Integer.parseInt(request.getParameter("thismessageid"));
        int gid = Integer.parseInt(request.getParameter("gid"));
        //DAO
        MessageServiceImpl service = new MessageServiceImpl();
        service.updatetmessagereply(msgid, userid, content);
        //查询该用户所有留言信息
        ArrayList<Message> message = new ArrayList<>();
        message = service.SelectUserMessage(gid);
        request.setAttribute("messageinfo", message);
        request.setAttribute("gid", gid);
        request.getRequestDispatcher("/public/page/detail.jsp").forward(request, response);
    }

    private void selectmessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null) {
            response.sendRedirect("login.jsp");
            return;
        }
        //接收数据
        int gid = 2;
        //查询该用户所有留言信息
        MessageServiceImpl service = new MessageServiceImpl();
        ArrayList<Message> message = new ArrayList<>();
        message = service.SelectUserMessage(gid);
        request.setAttribute("gid", gid);
        request.setAttribute("messageinfo", message);
        request.getRequestDispatcher("/public/page/detail.jsp").forward(request, response);
    }
}
