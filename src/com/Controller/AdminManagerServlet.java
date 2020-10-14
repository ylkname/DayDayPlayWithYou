package com.Controller;

import com.Bean.*;
import com.Service.IAdminService;
import com.Service.ServiceImpl.IAdminServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class AdminManagerServlet extends AdminBaseController {
    IAdminService adminService = new IAdminServiceImpl();

    /**
     * 显示所有用户
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service完成查询
        final List<User> user = adminService.findUser();
        //2.将list存入request域
        request.setAttribute("user", user);
        //3.转发到list.jsp
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    /**
     * 显示所有陪玩
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void playMenList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service完成查询
        final List<User> playMen = adminService.findPlayMen();
        //2.将list存入request域
        request.setAttribute("playMen", playMen);
        //3.转发到list.jsp
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    /**
     * 显示所有管理员
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void adminList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service完成查询
        final List<Admin> admin = adminService.findAdmin();
        //2.将list存入request域
        request.setAttribute("admin", admin);
        //3.转发到list.jsp
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    /**
     * 修改身份
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Applicant applicant = new Applicant();
        try {
            BeanUtils.populate(applicant, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        adminService.updateRole(applicant);
    }

    /**
     * 管理员登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        HttpSession session = request.getSession();
        Admin admin = new Admin();
        try {
            BeanUtils.populate(admin, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用Service查询
        Admin loginAdmin = adminService.login(admin);
        //判断是否登录成功
        if (loginAdmin != null) {//登录成功
            //将用户存入session
            session.setAttribute("admin", loginAdmin);
            //跳转页面
            response.sendRedirect(request.getContextPath() + "/admin.jsp");
        } else {//登录失败
            //提示信息
            request.setAttribute("login_msg", "用户名或密码错误！");
            //调转登录界面
            request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
        }
    }

    /**
     * 添加管理员
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        final Map<String, String[]> map = request.getParameterMap();
        //封装对象
        Admin admin = new Admin();
        try {
            BeanUtils.populate(admin, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用service保存
        adminService.addAdmin(admin);
        //5.跳转到userListServlet
        response.sendRedirect(request.getContextPath() + "/");
    }

    /**
     * 删除管理员
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String id = request.getParameter("id");
        adminService.delAdmin(id);
        response.sendRedirect(request.getContextPath() + "/");
    }

    /**
     * 展示陪玩申请
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Applicant> applicants = adminService.findApply();
        request.setAttribute("applicant", applicants);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        //获取条件查询
        Map<String, String[]> condition = request.getParameterMap();
        //2.调用service查询
        PageBean<User> pageBean = adminService.findByPage(currentPage, rows, condition);
        //3.将pageBean存入request
        request.setAttribute("pageBean", pageBean);
        //将查询条件存入request
        request.setAttribute("condition", condition);
        //4.转发到list.jsp
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    /**
     * 更新用户信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取map
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用service修改
        adminService.updateUser(user);
        //5.跳转到查询所有service
        response.sendRedirect(request.getContextPath() + "/");
    }

    /**
     * 添加陪玩
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addPlayMen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        PlayMen playMen = new PlayMen();
        try {
            BeanUtils.populate(playMen, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        adminService.addPlayMen(playMen);
    }

    /**
     * 删除陪玩
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delPlayMen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String id = request.getParameter("id");
        adminService.delPlayMen(id);
        response.sendRedirect(request.getContextPath() + "/");
    }

    /**
     * 删除陪玩申请
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String id = request.getParameter("id");
        adminService.delApply(id);
        response.sendRedirect(request.getContextPath() + "/");
    }
}