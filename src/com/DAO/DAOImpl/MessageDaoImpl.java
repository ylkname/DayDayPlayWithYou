package com.DAO.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;

import com.DAO.MessageDAO;
import com.JDBCUtil.JDBCUtils;
import com.JDBCUtil.Tools;
import com.Service.IUserService;
import com.sun.rowset.CachedRowSetImpl;

import com.Bean.Message;
import com.Bean.Reply;
import com.Bean.User;
import com.Service.ServiceImpl.UserServiceImpl;

public class MessageDaoImpl implements MessageDAO {
	/**
	 * 查询该用户所有留言记录，并按时间排序
	 * 
	 * @param gid
	 * @return
	 */
	public ArrayList<Message> SelectUserMessage(int gid) {
		ArrayList<Message> message = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "SELECT * FROM usermessage WHERE guid = ? ORDER BY writetime DESC";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gid);
			res = ps.executeQuery();
			// 数据处理
			while (res.next()) {
				message.add(getMessage(res));
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
		return message;
	}

	/**
	 * 将查询结果转换为message对象
	 * 
	 * @param res
	 * @return
	 */
	private Message getMessage(ResultSet res) {
		Message message = new Message();
		IUserService userService=new UserServiceImpl();
		User user = null;
		try {
			message.setId(res.getInt("MessageId"));
			message.setWuid(res.getInt("wuid"));
			user = userService.selectoneuser(message.getWuid());
			message.setWname(user.getName());
			message.setWimg(user.getPhoto());
			message.setGuid(res.getInt("guid"));
			message.setMsgtext(res.getString("MessageText"));
			if(res.getString("ReplyMessage")!=null&&res.getString("ReplyMessage").length()>0)
				message.setReptext(selectUserReplyMessage(res.getString("ReplyMessage")));
			message.setWritetime(res.getString("writetime"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	/**
	 * 查询留言回复信息
	 * 
	 * @param content
	 * @return Reply回复集合
	 */
	public ArrayList<Reply> selectUserReplyMessage(String content) {
		content = content.trim();
		String[] one_msg = content.split(">");
		String[] one_msg_info = null;
		ArrayList<Reply> replys = new ArrayList<>();
		User user = new User();
		UserDAOImpl dao = new UserDAOImpl();
		for (String value : one_msg) {
			one_msg_info = value.split("<");
			Reply re = new Reply();
			for (int i = 0; i < one_msg_info.length; i++) {
				if (i == 0) {
					re.setId(Integer.parseInt(one_msg_info[0]));
					user = dao.selectoneuser(re.getId());// 查询用户name和头像路径
					re.setImg(user.getPhoto());
					re.setName(user.getName());
				}
				if (i == 1)
					re.setContent(one_msg_info[1]);
				if (i == 2)
					re.setTime(one_msg_info[2]);
			}
			replys.add(re);
		}
		return replys;
	}

	/**
	 * 增加留言
	 * @param wid-留言者id（写留言的人）
	 * @param gid-被留言者id（收留言的人）
	 * @param content-留言内容
	 * @return
	 */
	public int addmessage(int wid, int gid, String content) {
		Connection conn = null;
		PreparedStatement ps = null;
		int end = 0;
		String time = Tools.gettimenow();
		String sql = "INSERT INTO usermessage (wuid,guid,MessageText,writetime) VALUES (?,?,?,?)";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, wid);
			ps.setInt(2, gid);
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
	 * 根据msgid查询回复信息
	 * @param msgid-留言编号
	 * @return
	 */
	public ResultSet selectReplyByMsgId(int msgid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		CachedRowSet rowset = null;
		String sql = "SELECT * FROM usermessage WHERE MessageId = ?";
		try {
			rowset = new CachedRowSetImpl();
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, msgid);
			res = ps.executeQuery();
			rowset.populate(res, 1);
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
		return rowset;
	}

	/**
	 * 添加留言回复功能
	 * @param msgid-留言编号
	 * @param userid-回复者id
	 * @param content-回复内容 回复拼接格式：旧的回复内容+id<content<time>
	 * @return
	 */
	public int updatetmessagereply(int msgid, int userid, String content) {
		int end = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE usermessage SET ReplyMessage=? WHERE MessageId=?";
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&gt;");
		String time = Tools.gettimenow();
		ResultSet oldmessageinfo = selectReplyByMsgId(msgid);// 获取原数据库的留言回复内容，然后开始字符串的拼接
		StringBuffer oldMessageReply = new StringBuffer();
		try {
			if (oldmessageinfo.next()) {
				if (oldmessageinfo.getString("ReplyMessage") != null&&oldmessageinfo.getString("ReplyMessage").length()>0) {
					oldMessageReply.append(oldmessageinfo.getString("ReplyMessage"));
				}
				oldMessageReply.append(userid + "<" + content + "<" + time + ">");
				conn = JDBCUtils.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, oldMessageReply.toString());
				ps.setInt(2, msgid);
				end = ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oldmessageinfo != null)oldmessageinfo.close();
				if(ps != null)ps.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return end;
	}
}
