package com.Bean;
/*
用户实现类
 */
public class User {
    private int id;//id
    private String user_name;//用户名
    private String user_password;//密码
    private String name;//昵称
    private String photo;//图片
    private String qq_num;//qq号
    private String phone;//电话号码
    private int money;//支付金额
    private int role;//用户角色
    private int condition;//支付状态

    public User() {
    }

    public User(int id, String user_name, String user_password,
                String name, String photo, String qq_num, String phone,
                int money, int role, int condition) {
        this.id = id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.name = name;
        this.photo = photo;
        this.qq_num = qq_num;
        this.phone = phone;
        this.money = money;
        this.role = role;
        this.condition = condition;
    }

    public User(String user_name, String user_password, String name, String phone) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getQq_num() {
        return qq_num;
    }

    public void setQq_num(String qq_num) {
        this.qq_num = qq_num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", qq_num='" + qq_num + '\'' +
                ", phone='" + phone + '\'' +
                ", money=" + money +
                ", role=" + role +
                ", condition=" + condition +
                '}';
    }
}
