package com.daytime;

import java.util.List;

/**
 * Description: 测试方法类
 * Author: Jiangchangpeng
 * Date: 2023/11/26/14:57
 */
public class TestMethod {

    public static void main(String[] args) {
        String phone = RegexUtils.PATTERN_MOBILE_PHONE;
        String id = RegexUtils.PATTERN_ID_CARD;
        String url = RegexUtils.PATTERN_URL;
        String email = RegexUtils.PATTERN_EMAIL;
        String input = "13800138000";
        String inputId = "130101199001011234";
        String inputurl = "https://www.baidu.com";
        String inputemail = "27995132124919@woaolanqiu";

//        System.out.println(RegexUtils.checkPassword("Jcp199661", 20, true, true, true, false));

    }
}


