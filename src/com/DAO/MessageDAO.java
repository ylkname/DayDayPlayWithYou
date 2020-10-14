package com.DAO;

import com.Bean.Message;
import com.Bean.Reply;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface MessageDAO {
    /**
     * 查询该用户所有留言记录，并按时间排序
     *
     * @param gid
     * @return
     */
    public ArrayList<Message> SelectUserMessage(int gid);

    /**
     * 查询留言回复信息
     *
     * @param content
     * @return Reply回复集合
     */
    public ArrayList<Reply> selectUserReplyMessage(String content);
    /**
     * 增加留言
     * @param wid-留言者id（写留言的人）
     * @param gid-被留言者id（收留言的人）
     * @param content-留言内容
     * @return
     */
    public int addmessage(int wid, int gid, String content);
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
     * @param content-回复内容 回复拼接格式：旧的回复内容+id<content<time>
     * @return
     */
    public int updatetmessagereply(int msgid, int userid, String content);
}
