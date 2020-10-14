package com.Controller;

import com.Bean.AdminUser;
import com.Bean.JsonResult;
import com.Bean.User;
import com.Factory.BeanFactory;
import com.DAO.DAOImpl.AdminDaoImpl;
import com.DAO.DAOImpl.UserDAOImpl;
import com.Factory.BeanFactory;
import com.Service.IUserService;
import com.Service.ServiceImpl.UserServiceImpl;
import com.google.gson.Gson;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "userController",urlPatterns = {"*.do"})
public class UserController extends HttpServlet {
    UserDAOImpl userDAO= BeanFactory.getInstance("IUserDao");
    //UserServiceImpl userService=BeanFactory.getInstance("IUserService");
    AdminDaoImpl adminDao= BeanFactory.getInstance("IAdminDao");
    IUserService userService=new UserServiceImpl(userDAO,adminDao);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        doGet(request,response);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath=req.getServletPath();
        if(servletPath.contains("resign.do")){
            try {
                resign(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(servletPath.contains("login.do")){
            try {
                login(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(servletPath.contains("recharge.do")){
            try {
                recharge(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    protected void resign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String user_name=request.getParameter("yyid");//账号
        String name = request.getParameter("user");//昵称
        String password = request.getParameter("password");
        String phone=request.getParameter("phone");
        User user=new User(user_name,password,name,phone);
        boolean flag = userService.iExistUser(user_name);
        Gson json=new Gson();
        JsonResult jsonResult=new JsonResult();
        if (flag==true){
            userService.resign(user);
            jsonResult.setResult("1001");
            System.out.println("注册成功");

        }else {
            System.out.println("注册失败");
            jsonResult.setMsg("用户名已经被注册");
            jsonResult.setResult("1000");
        }
        response.getWriter().write(json.toJson(jsonResult));
    }

    /*
      选择用户登录还是管理员登录
      1：用户
      2：管理员
    */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String type=req.getParameter("type");//选择用户类型
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //  System.out.println(type);
        if("1".equals(type)){//用户
            adminLogin(req,resp,username,password);
        }
        if("2".equals(type)){//管理员
            userLogin(req,resp,username,password);
        }
    }

    //用户登录
    protected void adminLogin(HttpServletRequest req,HttpServletResponse resp,String username,String password) throws ServletException, IOException, SQLException {
        User user = userService.login(username, password);
        Gson gson=new Gson();
        JsonResult jr=new JsonResult();
        HttpSession session= req.getSession();
        if(user!=null){
            int money = user.getMoney();
            String str="/public/page/index.jsp";
            //  req.getRequestDispatcher("/index.jsp").forward(req,resp);
            session.setAttribute("money",money);
            session.setAttribute("id",user.getId());
            session.setAttribute("user",user);
          //  Object user1 = session.getAttribute("user");
            req.getRequestDispatcher(str).forward(req,resp);
           // jr.setResult("1001");
        }
        else {
            System.out.println("登录失败");
            jr.setResult("1000");
            jr.setMsg("用户名或者密码错误");
        }
        //resp.getWriter().write(gson.toJson(jr));
    }
    //管理员登录
    protected void userLogin(HttpServletRequest req, HttpServletResponse resp,String username,String password) throws ServletException, IOException, SQLException {
        AdminUser adminUser = userService.adminLogin(username, password);
        Gson gson=new Gson();
        JsonResult jr=new JsonResult();
        // HttpSession session=req.getSession();
        if(adminUser!=null){
            System.out.println("管理员登录成功");
            //req.getRequestDispatcher("/index.jsp").forward(req,resp);
            String str="/public/page/admin.jsp";
            req.getRequestDispatcher(str).forward(req,resp);
        }
        else {
            jr.setResult("1000");
            jr.setMsg("用户名或者密码错误");
        }
    }
    //充值
    protected void recharge(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException, SQLException {
        String money=req.getParameter("money");
        System.out.println(money);
        String addMoney[]=money.split("元");
        Gson gson=new Gson();
        JsonResult jr=new JsonResult();
        int id = (Integer)req.getSession().getAttribute("id");
        //System.out.println(id);
        int num = userService.addMoney(Integer.parseInt(addMoney[0]), id);
        if(num<0){
            System.out.println("充值失败");
            jr.setResult("1000");
            jr.setMsg("请输入正确的金额");

        }else {
            User user = userService.queryUserById(id);
            System.out.println("充值成功");
            System.out.println(user.getMoney());
            HttpSession session=req.getSession();
            session.setAttribute("money",user.getMoney());
            jr.setResult("1001");
            jr.setMsg("充值成功");
        }
        resp.getWriter().write(gson.toJson(jr));
    }
}
