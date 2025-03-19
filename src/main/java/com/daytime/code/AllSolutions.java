package com.daytime.code;

import org.apache.commons.math3.stat.descriptive.summary.Sum;

import java.util.*;

/**
 * Description:最长连续序列
 * Author: Jiangchangpeng
 * Date: 2025/02/14/14:47
 */
public class AllSolutions {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int cur = num;
                int count = 1;
                while (numSet.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public void moveZeroes(int[] nums) {
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[current] = nums[i];
                current++;
            }
        }
        for (int i = current; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int area = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                area = Math.max(area, height[left] * (right - left));
                left++;
            } else {
                area = Math.max(area, height[right] * (right - left));
                right--;
            }
        }
        return area;


    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> characters = new HashSet<>();
        int res = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (characters.contains(c)) {
                characters.remove(s.charAt(left));
                left++;
            }
            characters.add(c);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int length = p.length();
        char[] array1 = s.toCharArray();
        char[] array2 = p.toCharArray();
        Arrays.sort(array2);
        for (int i = 0; i < s.length(); i++) {
            if (i + length <= s.length()) {
                char[] array3 = Arrays.copyOfRange(array1, i, i + length);
                Arrays.sort(array3);
                if (Arrays.equals(array2, array3)) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;

    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] newres = new int[length];
        for (int i = 0; i < length; i++) {
            newres[(i + k) % length] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = newres[i];
        }


    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int plus = 1;
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    plus *= nums[j];
                }
            }
            res[i] = plus;
        }
        return res;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode current = head;
        while (current.next != null) {
            if (visited.contains(current)) {
                return current;
            } else {
                visited.add(current);
            }
            current = current.next;
        }
        return null;

    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> integers = new ArrayList<>();
        while (head.next != null){
            integers.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = integers.size() - 1;
        while (left < right){
            if (integers.get(left) != integers.get(right)){
                return false;
            }
            left++;
            right --;
        }

        return true;
    }

    public int climbStairs(int n) {
       if (n <=1 ){
           return 1;
       }
       int[] f = new int[n + 1];
       f[0] = 1;
       f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[n] = f[n-1] + f[n-2];
        }
        return f[n];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if (n == 0){return 0;}
        if (n == 1) {return nums[0];}
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i] ,dp[i-1]);
        }
        return dp[n-1];
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] f = new int[length];
        f[0] = 1;
        int max = 1;
        for(int i = 1 ;i < length ; i++){
            f[i] = 1;
            for(int j = 0 ; j< i; j++){
                if(nums[i] > nums[j]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
         max = Math.max(max, f[i]);
        }
        return max;
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String temp = "";
        backTracking(n, 0, 0, temp, res);
        return res;
    }

    public  void backTracking(int n , int left , int right , String temp, List<String> res){
        if (right > left) {
            return ;
        }
        if (left == n && right == n){
            res.add(temp);
            return;
        }
        if (left < n){
            backTracking(n, left + 1, right, temp + "(", res);
        }
        if (right < left){
            backTracking(n, left, right + 1, temp + ")", res);
        }

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        //dp[i] 应该表示前 i 个字符是否可以由字典 wordDict 拆分，所以 dp 数组应该是 length + 1 大小：
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
               if(dp[j] && wordSet.contains(word)){
                   dp[i] = true;
                   break;
               }
            }
        }
        return dp[length];
    }



}
