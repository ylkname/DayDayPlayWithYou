package com.Factory;

import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

public class BeanFactory{
    private static ResourceBundle resourceBundle;

    /**
     * 使用国际化操作读取资源文件
     */
    static {
    resourceBundle =ResourceBundle.getBundle("bean");
    }

    /**
     * 获取对象的工厂类方法
     * @param key 获得实现接口的key，对应bean资源文件中的值
     * @param <T> 设置泛型，使返回值根据获得的要求而改变
     * @return
     */
    public static <T> T getInstance(String key){
        try {
            Class cls = Class.forName(resourceBundle.getString(key));
            return (T)cls.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
