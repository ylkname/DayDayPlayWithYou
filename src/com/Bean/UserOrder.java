package com.Bean;
/*
用户订单实现类
 */
public class UserOrder {
    private Integer id;
    private String order_num;
    private String playmen_name;
    private String game_name;
    private Integer price;
    private Integer num;
    private Integer all_price;
    private Integer condition;
    private Integer user_id;

    public UserOrder() {
    }

    public UserOrder( String order_num, String playmen_name, String game_name, Integer price, Integer num, Integer all_price, Integer condition, Integer user_id) {
        this.order_num = order_num;
        this.playmen_name = playmen_name;
        this.game_name = game_name;
        this.price = price;
        this.num = num;
        this.all_price = all_price;
        this.condition = condition;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", order_num='" + order_num + '\'' +
                ", playmen_name='" + playmen_name + '\'' +
                ", game_name='" + game_name + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", all_price=" + all_price +
                ", condition=" + condition +
                ", user_id=" + user_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getPlaymen_name() {
        return playmen_name;
    }

    public void setPlaymen_name(String playmen_name) {
        this.playmen_name = playmen_name;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getAll_price() {
        return all_price;
    }

    public void setAll_price(Integer all_price) {
        this.all_price = all_price;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
