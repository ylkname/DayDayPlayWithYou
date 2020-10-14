package com.Bean;

import java.sql.Timestamp;

public class UserGift {
    private Integer id;
    private Integer user_id;
    private Integer gift_id;
    private Integer gift_num;
    private Integer playmen_id;
    private Timestamp date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getGift_id() {
        return gift_id;
    }

    public void setGift_id(Integer gift_id) {
        this.gift_id = gift_id;
    }

    public Integer getGift_num() {
        return gift_num;
    }

    public void setGift_num(Integer gift_num) {
        this.gift_num = gift_num;
    }

    public Integer getPlaymen_id() {
        return playmen_id;
    }

    public void setPlaymen_id(Integer playmen_id) {
        this.playmen_id = playmen_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Userpluss{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", gift_id=" + gift_id +
                ", gift_num=" + gift_num +
                ", playmen_id=" + playmen_id +
                ", date=" + date +
                '}';
    }

    public UserGift(Integer id, Integer user_id, Integer gift_id, Integer gift_num, Integer playmen_id, Timestamp date) {
        this.id = id;
        this.user_id = user_id;
        this.gift_id = gift_id;
        this.gift_num = gift_num;
        this.playmen_id = playmen_id;
        this.date = date;
    }

    public UserGift() {
    }
}
