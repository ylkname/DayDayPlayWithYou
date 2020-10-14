package com.JDBCUtil;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    public static<T> T  copyParamTobean(Map value, T bean) {
        try {
            System.out.println("注入之前" + bean);
            /**
             * 把所有请求的参数注入到User中
             */
            BeanUtils.populate(bean, value);
            System.out.println("注入之后" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 把String类型的数据转换为int 类型
     * @param id
     * @param i
     * @return
     */
    public static int parseInt(String id, int i) {
        try {
            return Integer.parseInt(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
