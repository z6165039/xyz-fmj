package com.jis.platform.fmj.sfexpress;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: RedisUtil
 */
public class CheckFieldUtils {

	/**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(18[0-9])|(15[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
 
    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
 
    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";
 
 
    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
 
    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
    
    public static final  String[] vi = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };

	
	/**
	 * 判断字符串是否是整数
	 */
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否是浮点数
	 */
	public static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			if (value.contains("."))
				return true;
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 检查身份证号码合法性
	 * 
	 * @param idCardNo
	 * @return
	 * @throws Exception
	 */
	public boolean isSFZ(String idCardNo) throws Exception {
		try {
			if (StringUtils.isEmpty(idCardNo)) {
				return false;
			}
			int length = idCardNo.length();
			if (length == 15) {
				Pattern p = Pattern.compile("^[0-9]*$");
				Matcher m = p.matcher(idCardNo);
				return m.matches();
			} else if (length == 18) {
				String front_17 = idCardNo.substring(0, idCardNo.length() - 1);// 号码前17位
				String verify = idCardNo.substring(17, 18);// 校验位(最后一位)
				Pattern p = Pattern.compile("^[0-9]*$");
				Matcher m = p.matcher(front_17);
				if (!m.matches()) {
					return false;
				} else {
					checkVerify(front_17, verify);
				}
			}
			return false;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 校验验证位合法性
	 * 
	 * @param front_17
	 * @param verify
	 * @return
	 * @throws Exception
	 */
	private static boolean checkVerify(String front_17, String verify) throws Exception {
		try {
			int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
			int s = 0;
			for (int i = 0; i < front_17.length(); i++) {
				int ai = Integer.parseInt(front_17.charAt(i) + "");
				s += wi[i] * ai;
			}
			int y = s % 11;
			String v = vi[y];
			if (!(verify.toUpperCase().equals(v))) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
 
    /**
     * 校验邮箱
     * 
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }
 
    /**
     * 校验汉字
     * 
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }
 
 
    /**
     * 校验URL
     * 
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }
 
    /**
     * 校验IP地址
     * 
     * @param ipAddr
     * @return
     */
    public static boolean isIp(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }
	
    
    /**
     * 电话号码验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isTel(String str) {
        Pattern p1 = null, p2 = null;
        Matcher m  = null;
        boolean b  = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
        if (str.length() > 9) {
            m = p1.matcher(str);
            b = m.matches();
        } else {
            m = p2.matcher(str);
            b = m.matches();
        }
        return b;
    }
}
