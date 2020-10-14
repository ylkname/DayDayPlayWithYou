package com.Controller;

import com.Bean.Gifts;
import com.Bean.Page;
import com.Service.GiftsService;
import com.Service.ServiceImpl.GiftsServiceImpl;
import com.JDBCUtil.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GiftsServlet")
public class GiftsServlet extends BaseServlet {
    private GiftsService giftsService=new GiftsServiceImpl();

    /**
     * 处理分页功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        System.out.println("经过了前台的BookServlet程序");
        //1、获取请求的参数 pageNo和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用BookServlet.page(pageNo,pageSize):Page对象
        Page<Gifts> page = giftsService.page(pageNo, pageSize);
        page.setUrl("manager/giftsServlet?action=page");
        //3、保存Page对象到request域中
        request.setAttribute("page", page);
        //4、请求转发到pages/manager/book_manager.jsp
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int pageNo=WebUtils.parseInt(request.getParameter("pageNo"),0);
        pageNo+=1;
        Gifts gifts= WebUtils.copyParamTobean(request.getParameterMap(),new Gifts());
        giftsService.addGifts(gifts);
//        request.getRequestDispatcher("/manager/bookServlet?action=list").forward(request,response);
        //重定向
        response.sendRedirect(request.getContextPath()+"/manager/giftsServlet?action=page&pageNo="+pageNo);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        //        1、获取请求的参数id，图书编程
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
//        2、调用bookService.deleteBookById();删除图书
        giftsService.deleteGiftsById(id);
//        3、重定向回图书列表管理页面
//                /book/manager/bookServlet?action=list
        response.sendRedirect(request.getContextPath() + "/manager/giftsServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Gifts gifts= WebUtils.copyParamTobean(request.getParameterMap(),new Gifts());
        giftsService.updateGifts(gifts);
        response.sendRedirect(request.getContextPath() + "/manager/giftsServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        //1、获取请求的参数图书编号
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        //2 调用bookService.queryBookById查询图书
        Gifts gift=giftsService.queryGiftsById(id);
        //3 保存到图书到Request域中
        request.setAttribute("gift",gift);
        //4 请求转发到。pages/manager/book_edit.jsp页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        //1 通过BookService查询全部图书
        List<Gifts> gifts=giftsService.queryGifts();
        //2 把全部图书保存到Request域中
        request.setAttribute("gifts",gifts);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
}