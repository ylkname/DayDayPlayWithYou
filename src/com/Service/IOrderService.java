package com.Service;

import com.Bean.PlayMenOrder;
import com.Bean.UserOrder;

import java.util.List;

public interface IOrderService {

    /**
     * 生成用户订单
     * @param userOrder
     */
    public boolean doAddUserOrder(UserOrder userOrder);

    /**
     * 删除用户订单
     * @param id 用户订单id
     * @return 判断是否删除成功
     */
    public boolean doDeleteUserOrder(int id);

    /**
     * 返回所有用户订单信息
     * @return 用户订单集合
     */
    public List<UserOrder> doGetUserOrder();

    /**
     * 生成配玩订单
     * @param playMenOrder
     */
    public boolean doAddPlayMenOrder(PlayMenOrder playMenOrder);

    /**
     * 删除陪玩订单
     * @param id 陪玩订单id
     * @return 判断是否删除成功
     */
    public boolean doDeletePlayMenOrder(int id);

    /**
     * 返回所有陪玩订单信息
     * @return 陪玩订单集合
     */
    public List<PlayMenOrder> doGetPlayMenOrder();
}
