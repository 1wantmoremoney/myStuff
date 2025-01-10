package com.daytime;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: 正则工具类
 * Author: JiangChangPeng
 * Date: 2023/11/24/14:33
 */
public class RegexUtils {


    private RegexUtils() {
        // 私有构造方法，禁止外部实例化
    }

    /**
     * 验证给定的字符串是否匹配指定的正则表达式
     *
     * @param input   待验证的字符串
     * @param pattern 正则表达式
     * @return 如果匹配则返回 true，否则返回 false
     */
    public static boolean isValid(String input, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        return matcher.matches();
    }



    /**
     * 验证手机号码格式是否正确
     */
    public static final String PATTERN_MOBILE_PHONE = "^1[3456789]\\d{9}$";

    /**
     * 验证身份证号码格式是否正确
     */
    public static final String PATTERN_ID_CARD = "^(\\d{14}|\\d{17})(\\d|[xX])$";

    /**
     * 验证中国手机号码格式是否正确
     */
    public static final String PATTERN_CHINA_MOBILE_PHONE = "^1(3[0-9]|4[579]|5[0-35-9]|6[56]|7[0135678]|8[0-9]|9[89])\\d{8}$";

    /**
     * 验证中国固定电话号码格式是否正确
     */
    public static final String PATTERN_CHINA_TEL = "^0(10|2[0-5789]|3[01256789]|4[016-9]|5[01256789]|6[56789]|82|7[016-8])\\d{7,8}$";

    /**
     * 验证URL地址格式是否正确
     */
    public static final String PATTERN_URL = "(ht|f)tp(s?)\\:\\/\\/[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*(:(0-9)*)*(\\/?)([a-zA-Z0-9\\-\\.\\?\\,\\'\\/\\\\&%\\+\\$#_=]*)?";

    /**
     * 验证邮箱地址格式是否正确
     */
    public static final String PATTERN_EMAIL = "^[a-zA-Z0-9_\\-\\.]+@([a-zA-Z0-9_\\-\\.]+\\.)+[a-zA-Z]{2,4}$";




}
