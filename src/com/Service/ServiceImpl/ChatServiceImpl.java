package com.Service.ServiceImpl;

import com.Bean.Chat;
import com.DAO.DAOImpl.ChatDaoImpl;
import com.Service.IChatService;


import java.util.ArrayList;

public class ChatServiceImpl implements IChatService {
    private ChatDaoImpl chatDao = new ChatDaoImpl();

    /**
     * 增加聊天信息
     * @param senderId 发送者Id
     * @param receiverId 接收者Id
     * @param content 聊天内容
     * @return
     */
    public int send(int senderId, int receiverId, String content) {
        return chatDao.send(senderId, receiverId, content);
    }
    /**
     * 查询该用户所有聊天信息，并按时间排序
     * @param
     * @return
     */
    public ArrayList<Chat> selectUserMessage(int rid,int sid) {
        return chatDao.SelectUserMessage(rid, sid);
    }
}