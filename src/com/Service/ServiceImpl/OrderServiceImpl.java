package com.Service.ServiceImpl;

import com.Bean.PlayMenOrder;
import com.Bean.UserOrder;
import com.DAO.IOrderDAO;
import com.Service.IOrderService;

import java.util.List;

public class OrderServiceImpl implements IOrderService {

    private IOrderDAO orderDAO;
    public OrderServiceImpl(){

    }

    public OrderServiceImpl(IOrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    @Override
    public boolean doAddUserOrder(UserOrder userOrder) {
        boolean flag = orderDAO.doAddUserOrder(userOrder);
        return flag;
    }

    @Override
    public boolean doDeleteUserOrder(int id) {
        boolean flag = orderDAO.doDeleteUserOrder(id);
        return flag;
    }

    @Override
    public List<UserOrder> doGetUserOrder() {
        List<UserOrder> userOrderList = orderDAO.doGetUserOrder();
        return userOrderList;
    }

    @Override
    public boolean doAddPlayMenOrder(PlayMenOrder playMenOrder) {
        boolean flag = orderDAO.doAddPlayMenOrder(playMenOrder);
        return flag;
    }

    @Override
    public boolean doDeletePlayMenOrder(int id) {
        boolean flag = orderDAO.doDeletePlayMenOrder(id);
        return flag;
    }

    @Override
    public List<PlayMenOrder> doGetPlayMenOrder() {
        List<PlayMenOrder> playMenOrderList = orderDAO.doGetPlayMenOrder();
        return playMenOrderList;
    }
}
