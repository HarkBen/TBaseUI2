package com.rg.function.utils;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 验证工具类
 *
 * @author Administrator
 */
public class Verifier {
    /**
     * 注册验证两次密码是否一致
     *
     * @param psw1
     * @param psw2
     * @return
     */
    public static boolean pswVerifier(String psw1, String psw2) {
        if (!(psw1.trim().equals(psw2.trim()))) {
            return false;
        }
        return true;
    }

    /**
     * 判空
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        if (str == null)
            return true;
        if (str.trim().equals(""))
            return true;
        if (str.equalsIgnoreCase("null"))
            return true;
        return false;
    }
    public static boolean isNotNUll(String str){
            return  !isNull(str);
    }
    /**
     * 判空
     *
     * @return
     */
    public static boolean isNull(Long l) {
        if (l == null)
            return true;
        else
            return false;
    }

    /**
     * 判空
     *
     * @return
     */
    public static boolean isNull(Integer l) {
        if (l == null)
            return true;
        else
            return false;
    }


    /**
     * 手机号验证
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        /*
		 * 总结起来就是第一位必定为1，其他位置的可以为0-9(包含虚拟运营商)
		 */
        String telRegex = "[1][3578]\\d{9}";
        if (isNull(mobiles))
            return false;
        else
            return mobiles.matches(telRegex);
    }

    /**
     * 昵称 验证
     */
    public static boolean isNickName(String nickName) {
        String nameRegex = "^[a-zA-z]\\w{3,15}$";
        return nickName.matches(nameRegex);
    }

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * 姓名格式验证
     *
     * @param name
     * @return
     */
    public static boolean isName(String name) {
        // 汉字2到4位 或者英文名2到50位
        String nameRegex = "^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{2,50}$";
        if (isNull(name))
            return false;
        else
            return name.matches(nameRegex);
    }

    /**
     * 身份证验证格式验证
     *
     * @return
     */
    public static boolean isIDCard(String iDCard) {
        String IDCardRegex = "([1-9]\\d{5}[1-2]\\d{3}[0-1]\\d[0-3]\\d{4}(x|X|\\d))|([1-9]\\d{5}\\d{2}[0-1]\\d[0-3]\\d{3}(x|X|\\d))";
        if (isNull(iDCard)) {
            return false;
        }
        return iDCard.matches(IDCardRegex);
    }

    /**
     * 身高
     */
    public static boolean isStature(String stature) {
        String statureRegex = "([1-3]\\d{2})|([1-9]\\d)";
        if (isNull(stature)) {
            return false;
        }
        return stature.matches(statureRegex);
    }

    public static boolean isDateYear(String date) {
        String format = "([1-2]\\d{3})";
        return date.matches(format);
    }

    /**
     * 校验邮箱
     *
     * @param obj
     */
    public static boolean checkEmail(String obj) {
        String emailRegular = "^(\\w-*\\.*)+@(\\w-?)+(\\.\\w{2,})+$";
        return Pattern.matches(emailRegular, obj);
    }


    public static boolean isWebUrl(String url){
        String webUrlRegex = "((http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})" +
                "(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)|(www.[a-zA-Z0-9\\.\\-]+\\." +
                "([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)";
        return Pattern.matches(webUrlRegex, url);
    }

    /**
     * 邮箱格式验证
     */
    public static boolean isEmail(String email) {
        String emailRegex = "\\w[-\\w.+]*@([-\\w.+]+\\.)+[A-Za-z]{2,14}";
        return email.matches(emailRegex);
    }

    /**
     * Long == null or= 0
     */
    public static Long isNUll(Long l) {
        if (null == l) {
            return 0L;
        }
        return l;
    }

    public static Long toLong(String s) {
        if (null == s || "".equals(s)) {
            return 0L;
        }
        return Long.valueOf(s);
    }

    public static String toString(Object o) {
        if (o != null) {
            return String.valueOf(o);
        }
        return "";
    }

    public static String existence(String s) {
        if (null == s)
            return "";
        return s;
    }
    public static String existenceToString(Long s) {
        if (null == s)
            return "";
        return s+"";
    }
    public static String existenceToString(Integer s) {
        if (null == s)
            return "";
        return s+"";
    }
    public static String existenceToString(Float s) {
        if (null == s)
            return "";
        return s+"";
    }
    public static String existenceToString(Double s) {
        if (null == s)
            return "";
        return s+"";
    }
    public static Long existence(Long s) {
        if (null == s)
            return 0L;
        return s;
    }

    public static Integer existence(Integer s) {
        if (null == s)
            return 0;
        return s;
    }

    public static Float existence(Float f){
        if(null == f){
            return 0F;
        }
        return  f;
    }
    public static Double existence(Double s) {
        if (null == s)
            return 0.00;
        return s;
    }

    /**
     * 检查是否为纯数字
     */
    public static boolean isOnlyContainsNumber(String stature) {
        String statureRegex = "(^[0-9]*$)";
        if (isNull(stature)) {
            return false;
        }
        return stature.matches(statureRegex);
    }


    public  static boolean   isNotNUll(List<?> l){
        if(null != l && l.size() > 0){
            return  true;
        }else {
            return  false;
        }
    }
}
