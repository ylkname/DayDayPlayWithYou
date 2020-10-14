package com.Service;

import com.Bean.Message;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface IMessageService {
    /**
     * 查询该用户所有留言记录，并按时间排序
     * @param
     * @return
     */
    public ArrayList<Message> SelectUserMessage(int userid);
    /**
     * 增加留言
     * @param wid-留言者id（写留言的人）
     * @param gid-被留言者id（收留言的人）
     * @param content-留言内容
     * @return
     */
    public int addmessage(int wid,int gid,String content);
    /**
     * 根据msgid查询回复信息
     * @param msgid-留言编号
     * @return
     */
    public ResultSet selectReplyByMsgId(int msgid);
    /**
     * 添加留言回复功能
     * @param msgid-留言编号
     * @param userid-回复者id
     * @param content-回复内容
     * 回复拼接格式：旧的回复内容+id<content<time>
     * @return
     */
    public int updatetmessagereply(int msgid,int userid,String content);
}
