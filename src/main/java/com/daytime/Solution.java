package com.daytime;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description:
 * Author: Jiangchangpeng
 * Date: 2024/08/19/10:03
 */
public class Solution {
    public static void main(String[] args) {
    }

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        String[] split = p.split("");
        String pStringSorted = Arrays.stream(split).sorted().collect(Collectors.joining());
        int lengthP = p.length();
        for(int i = 0 ;i < s.length() ; i++){
            if (i + lengthP > s.length()) break;
            String compare = s.substring(i, i + lengthP);
            String[] split1 = compare.split("");
            String splitSorted = Arrays.stream(split1).sorted().collect(Collectors.joining());
            if (pStringSorted.equals(splitSorted)){
                res.add(i);
            }
        }
        return res;
    }
}
