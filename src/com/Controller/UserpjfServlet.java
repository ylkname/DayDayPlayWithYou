package com.Controller;

import com.Bean.Page;
import com.Bean.UserGifts;
import com.Service.GiftsService;
import com.Service.UserService;
import com.Service.ServiceImpl.GiftsServiceImpl;
import com.Service.ServiceImpl.UserServiceImpl;
import com.JDBCUtil.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

public class UserpjfServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    private GiftsService giftsService = new GiftsServiceImpl();

    //    private GiftsService giftsService=new GiftsServiceImpl();
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过了前台的BookServlet程序");
        //1、获取请求的参数 pageNo和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用BookServlet.page(pageNo,pageSize):Page对象
        Page<UserGifts> page = userService.page(pageNo, pageSize);
        page.setUrl("manager/giftsServlet?action=page");
        //3、保存Page对象到request域中
        request.setAttribute("pageuser", page);
        //4、请求转发到pages/manager/book_manager.jsp
        request.getRequestDispatcher("/public/newPage/gift.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserGifts user = WebUtils.copyParamTobean(request.getParameterMap(), new UserGifts());
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        user.setDate(nousedate);
        userService.addGifts(user);
//        request.getRequestDispatcher("/manager/bookServlet?action=list").forward(request,response);
        //重定向
        response.sendRedirect(request.getContextPath() + "/client/giftsServlet?action=list");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        1、获取请求的参数id，图书编程
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
//        2、调用bookService.deleteBookById();删除图书
        userService.deleteGiftsById(id);
//        3、重定向回图书列表管理页面
//                /book/manager/bookServlet?action=list
        response.sendRedirect(request.getContextPath() + "/manager/giftsServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserGifts gifts = WebUtils.copyParamTobean(request.getParameterMap(), new UserGifts());
        userService.updateGifts(gifts);
        response.sendRedirect(request.getContextPath() + "/manager/giftsServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求的参数图书编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2 调用bookService.queryBookById查询图书
        UserGifts gift = userService.queryGiftsById(id);
        //3 保存到图书到Request域中
        request.setAttribute("gift", gift);
        //4 请求转发到。pages/manager/book_edit.jsp页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 通过BookService查询全部图书
        List<UserGifts> gifts = userService.queryGifts();
        //2 把全部图书保存到Request域中
        request.setAttribute("gifts", gifts);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void paihang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        private Map<Map> maps=new Map();
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer obj1, Integer obj2) {
                        // 降序排序
                        return obj2.compareTo(obj1);
                    }
                });
//        String a="123";
//        map.put(a, "ccccc");
//        map.put("2018", "aaaaa");
//        map.put("2019", "bbbbb");
//        map.put("2011", "ddddd");
        Integer sum=0;
        Integer y=0;
        for(int i=1;i<6;i++) {
                for (UserGifts user : userService.queryGiftsBytId(i, 2)) {
                    Integer x = user.getGift_num() * (giftsService.queryGiftsById(user.getGift_id()).getPrice());
                    sum += x;
                    y = user.getUser_id();
                }
                map.put(sum, y);
            }

//        Set<Integer> keySet = map.keySet();
//
//        for (Integer key : keySet) {
//            System.out.println(key + ":" + map.get(key));
//        }
        request.setAttribute("map",map);

        request.getRequestDispatcher("/public/page/detail.jsp").forward(request, response);
    }
}


