package com.Bean;
/*
陪玩实现类
 */
public class PlayMen implements Comparable{
    private Integer id;
    private String name;
    private String sex;
    private String ID_name;
    private String ID_num;
    private String Game_name;
    private String Game_grade;
    private String APP_photo;
    private Double price;
    private String Room_id;
    public PlayMen(){

    }

    public PlayMen(String sex, String ID_name, String ID_num, String game_name, String game_grade, String APP_photo, Double price, String room_id) {
        this.sex = sex;
        this.ID_name = ID_name;
        this.ID_num = ID_num;
        Game_name = game_name;
        Game_grade = game_grade;
        this.APP_photo = APP_photo;
        this.price = price;
        Room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getID_name() {
        return ID_name;
    }

    public void setID_name(String ID_name) {
        this.ID_name = ID_name;
    }

    public String getID_num() {
        return ID_num;
    }

    public void setID_num(String ID_num) {
        this.ID_num = ID_num;
    }

    public String getGame_name() {
        return Game_name;
    }

    public void setGame_name(String game_name) {
        Game_name = game_name;
    }

    public String getGame_grade() {
        return Game_grade;
    }

    public void setGame_grade(String game_grade) {
        Game_grade = game_grade;
    }

    public String getAPP_photo() {
        return APP_photo;
    }

    public void setAPP_photo(String APP_photo) {
        this.APP_photo = APP_photo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRoom_id() {
        return Room_id;
    }

    public void setRoom_id(String room_id) {
        Room_id = room_id;
    }

    @Override
    public String toString() {
        return "PlayMen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", ID_name='" + ID_name + '\'' +
                ", ID_num='" + ID_num + '\'' +
                ", Game_name='" + Game_name + '\'' +
                ", Game_grade='" + Game_grade + '\'' +
                ", APP_photo='" + APP_photo + '\'' +
                ", price=" + price +
                ", Room_id='" + Room_id + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        PlayMen p=(PlayMen)o;
        if(this.getPrice()>p.getPrice()){
            return 1;
        }else {
            return -1;
        }
    }

}

