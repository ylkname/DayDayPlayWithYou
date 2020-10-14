package com.DAO;

import com.Bean.Chat;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface ChatDAO {
    /**
     * 发送聊天信息
     */
    int send(int senderId, int receiverId, String content);
    /**
     * 查询该用户所有留言记录，并按时间排序
     * @param
     * @return
     */
    ArrayList<Chat> SelectUserMessage(int senderId, int reveiverId);

}
