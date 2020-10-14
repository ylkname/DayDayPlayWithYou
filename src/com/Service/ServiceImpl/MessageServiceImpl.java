package com.Service.ServiceImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.Bean.Message;
import com.DAO.DAOImpl.MessageDaoImpl;
import com.Service.IMessageService;

public class MessageServiceImpl implements IMessageService {
	private MessageDaoImpl dao = new MessageDaoImpl();
	/**
	 * 查询该用户所有留言记录，并按时间排序
	 * @param
	 * @return
	 */
	public ArrayList<Message> SelectUserMessage(int userid) {
		return dao.SelectUserMessage(userid);
	}
	/**
	 * 增加留言
	 * @param wid-留言者id（写留言的人）
	 * @param gid-被留言者id（收留言的人）
	 * @param content-留言内容
	 * @return
	 */
	public int addmessage(int wid,int gid,String content) {
		return dao.addmessage(wid, gid, content);
	}
	/**
	 * 根据msgid查询回复信息
	 * @param msgid-留言编号
	 * @return
	 */
	public ResultSet selectReplyByMsgId(int msgid) {
		return dao.selectReplyByMsgId(msgid);
	}
	/**
	 * 添加留言回复功能
	 * @param msgid-留言编号
	 * @param userid-回复者id
	 * @param content-回复内容
	 * 回复拼接格式：旧的回复内容+id<content<time>
	 * @return
	 */
	public int updatetmessagereply(int msgid,int userid,String content) {
		return dao.updatetmessagereply(msgid, userid, content);
	}
}
