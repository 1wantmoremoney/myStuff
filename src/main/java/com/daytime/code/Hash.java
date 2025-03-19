package com.daytime.code;

import java.util.*;

/**
 * Description:
 * Author: Jiangchangpeng
 * Date: 2025/02/14/14:40
 */
public class Hash {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = Arrays.toString(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Hash().groupAnagrams(strs);
        System.out.println(lists);

    }

}
