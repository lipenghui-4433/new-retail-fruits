package cn.dingdong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author jiexue
 *
 */
public class DateUtils {

    private DateUtils() {
    }
    
	/**
	 * 获取当前时间
	 */
	public static long getCurrentDate() {
		return dateToLong(new Date());
	}

	public static Long dateToLong(Date date) {
		if (date != null) {
			return Long.valueOf(date.getTime());
		}
		return 0L;
	}
	
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	public static Long stringToLong(String str) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf.setLenient(false);
			date = sdf.parse(str);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Long.valueOf(date.getTime());
	}
}
