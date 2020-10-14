package com.Bean;

import java.util.ArrayList;

public class Message {
	private int id;
	private int wuid; //留言者id
	private String wname;//留言者用户名
	private String wimg;//留言者头像
	private int guid;//接收者id
	private String msgtext;//评论内容
	private ArrayList<Reply> reptext;//回复内容集合
	private String writetime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWuid() {
		return wuid;
	}
	public void setWuid(int wuid) {
		this.wuid = wuid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWimg() {
		return wimg;
	}
	public void setWimg(String wimg) {
		this.wimg = wimg;
	}
	public int getGuid() {
		return guid;
	}
	public void setGuid(int guid) {
		this.guid = guid;
	}
	public String getMsgtext() {
		return msgtext;
	}
	public void setMsgtext(String msgtext) {
		this.msgtext = msgtext;
	}
	public ArrayList<Reply> getReptext() {
		return reptext;
	}
	public void setReptext(ArrayList<Reply> reptext) {
		this.reptext = reptext;
	}
	public String getWritetime() {
		return writetime;
	}
	public void setWritetime(String writetime) {
		this.writetime = writetime;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", wuid=" + wuid + ", wname=" + wname + ", wimg=" + wimg + ", guid=" + guid
				+ ", msgtext=" + msgtext + ", reptext=" + reptext + ", writetime=" + writetime + "]";
	}
}
