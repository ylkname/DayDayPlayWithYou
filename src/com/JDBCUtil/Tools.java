package com.JDBCUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
	/**
	 * 获取当前系统时间
	 * @return
	 */
	public static String gettimenow(){
		Date a=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataString=formatter.format(a);
		return dataString;
	}
}
