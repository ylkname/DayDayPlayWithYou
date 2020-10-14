package com.DAO.DAOImpl;

import com.Bean.Chat;
import com.Bean.User;
import com.DAO.ChatDAO;
import com.JDBCUtil.JDBCUtils;
import com.JDBCUtil.Tools;
import com.Service.IUserService;
import com.Service.ServiceImpl.UserServiceImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChatDaoImpl implements ChatDAO {
    /**
     * 发送聊天信息
     */
    public int send(int senderId, int receiverId, String content) {
        Connection conn = null;
        PreparedStatement ps = null;
        int end = 0;
        String time = Tools.gettimenow();
        String sql = "INSERT INTO chat_message (sender_id,receiver_id,message_content,send_time) VALUES (?,?,?,?)";
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setString(3, content);
            ps.setString(4, time);
            end = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return end;
    }

    /**
     * 查询该用户所有留言记录，并按时间排序
     * @param
     * @return
     */
    public ArrayList<Chat> SelectUserMessage(int senderId,int reveiverId) {
        ArrayList<Chat> chats = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        String sql = "SELECT * FROM chat_message WHERE (receiver_id = ? and sender_id = ?)or(receiver_id = ? and sender_id = ?) ORDER BY send_time ASC ";
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reveiverId);
            ps.setInt(2,senderId);
            ps.setInt(3,senderId);
            ps.setInt(4,reveiverId);
            res = ps.executeQuery();
            // 数据处理
            while (res.next()) {
                chats.add(getChat(res));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (res != null)
                    res.close();
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return chats;
    }
    /**
     * 将查询结果转换为message对象
     *
     * @param res
     * @return
     */
    private Chat getChat(ResultSet res) {
        Chat chat=new Chat();
        User user = null;
        IUserService userService=new UserServiceImpl();
        try {
            chat.setId(res.getInt("id"));
            chat.setSenderId(res.getInt("sender_id"));
            user = userService.selectoneuser(chat.getSenderId());
            chat.setSenderName(user.getUser_name());
            chat.setSenderImg(user.getPhoto());
            chat.setReceiverId(res.getInt("receiver_id"));
            user= userService.selectoneuser(chat.getReceiverId());
            chat.setReceiverName(user.getUser_name());
            chat.setReceiverImg(user.getPhoto());
            chat.setMessageContent(res.getString("message_content"));
            chat.setSendTime(res.getString("send_time"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chat;
    }

}
