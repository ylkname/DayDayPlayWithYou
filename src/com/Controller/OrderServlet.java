package com.Controller;

import com.Bean.PlayMenOrder;
import com.Bean.UserOrder;
import com.DAO.DAOImpl.OrderDAOImpl;
import com.DAO.IOrderDAO;
import com.Service.IOrderService;
import com.Service.ServiceImpl.OrderServiceImpl;
import com.Factory.BeanFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "orderServlet",urlPatterns = {"*.doing"})
public class OrderServlet extends HttpServlet {
    IOrderDAO iOrderDAO=new OrderDAOImpl();
    IOrderService orderService=new OrderServiceImpl(iOrderDAO);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if(servletPath.contains("addPlayOrder.doing")){
            addPlayOrder(request,response);
        }else if(servletPath.contains("addUserOrder.doing")){
            addUserOrder(request,response);
        }else if(servletPath.contains("deletePlayOrder.doing")){
            deletePlayOrder(request,response);
        }else if(servletPath.contains("deleteUserOrder.doing")){
            deleteUserOrder(request,response);
        }else if(servletPath.contains("searchPlayOrder.doing")){
            searchPlayOrder(request,response);
        }else if(servletPath.contains("searchUserOrder.doing")){
            searchUserOrder(request,response);
        }
    }

    protected void addPlayOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order_num,playmen_name,game_name,price,num,all_price,condition,playmen_id;
        PlayMenOrder playMenOrder = null;
        boolean flag = false;

        // 得到用户参数信息
        order_num = request.getParameter("order_num");
        playmen_name = request.getParameter("playmen_name");
        game_name = request.getParameter("game_name");
        price = request.getParameter("price");
        num = request.getParameter("num");
        all_price = request.getParameter("all_price");
        condition = request.getParameter("condition");
        playmen_id = request.getParameter("playmen_id");

        playMenOrder = new PlayMenOrder(order_num,playmen_name,game_name,Integer.valueOf(price),Integer.valueOf(num),
                Integer.valueOf(all_price),Integer.valueOf(condition),Integer.valueOf(playmen_id));

        flag = orderService.doAddPlayMenOrder(playMenOrder);

        response.setContentType("text/html;charset=utf-8");
        if (flag){
            request.getRequestDispatcher("/Master_Edition.jsp").forward(request,response);
        }
    }

    protected void addUserOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order_num,playmen_name,game_name,price,num,all_price,condition,user_id;
        UserOrder userOrder = null;
        boolean flag = false;

        // 得到用户参数信息
        order_num = request.getParameter("order_num");
        playmen_name = request.getParameter("playmen_name");
        game_name = request.getParameter("game_name");
        price = request.getParameter("price");
        num = request.getParameter("num");
        all_price = request.getParameter("all_price");
        condition = request.getParameter("condition");
        user_id = request.getParameter("user_id");

        userOrder = new UserOrder(order_num,playmen_name,game_name,Integer.valueOf(price),Integer.valueOf(num),
                Integer.valueOf(all_price),Integer.valueOf(condition),Integer.valueOf(user_id));

        flag = orderService.doAddUserOrder(userOrder);

        response.setContentType("text/html;charset=utf-8");
        if (flag){
            request.getRequestDispatcher("/Master_Edition.jsp").forward(request,response);
        }
    }

    protected void deletePlayOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id;
        boolean flag;

        id = Integer.valueOf(request.getParameter("id"));
        flag = orderService.doDeletePlayMenOrder(id);
        response.setContentType("text/html;charset=utf-8");
        if (flag){
            request.getRequestDispatcher("/public/page/Play_Order.html").forward(request,response);
        }
    }

    protected void deleteUserOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id;
        boolean flag;

        id = Integer.valueOf(request.getParameter("id"));
        flag = orderService.doDeleteUserOrder(id);
        response.setContentType("text/html;charset=utf-8");
        if (flag){
            request.getRequestDispatcher("/public/page/Master_Order.html").forward(request,response);
        }
    }

    protected void searchUserOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        List<UserOrder> userOrderList = orderService.doGetUserOrder();

        if (userOrderList != null){
            // 调用jackson工具库，实现list-->json
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(userOrderList);
        }

        // 输出json数据，响应ajax请求，返回数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(json);
        pw.flush();
        pw.close();
    }

    protected void searchPlayOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        List<PlayMenOrder> playMenOrderList = orderService.doGetPlayMenOrder();

        if (playMenOrderList != null){
            // 调用jackson工具库，实现list-->json
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(playMenOrderList);
        }

        // 输出json数据，响应ajax请求，返回数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(json);
        pw.flush();
        pw.close();
    }
}
