package com.easycode.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String arg[]) {
        //int[] arrays1 = twoNumsum1(new int[]{3,3}, 6);
        /*Arrays.asList(arrays).forEach(x -> {
            System.out.println(x);
        });*/

        /*for (int i : arrays1) {
            System.out.print(i);
            System.out.print(" ");
        }*/

        System.out.println(lengthOfLongestSubstring("dvdf"));


    }

    public int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j= i + 1; j < nums.length ; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode r = null;
        ListNode rh = null;
        int jin = 0;
        while (h1 != null || h2 != null){


            int x = h1 == null ? 0 : h1.val;
            int y = h2 == null ? 0 : h2.val;
            int sum = x + y + jin;
            jin = sum / 10;
            if(jin > 0){
                sum = sum%10;
            }
            if(r == null){
                rh = r = new ListNode(sum);
            }else {
                r.next = new ListNode(sum);
                r = r.next;
            }

            if(h1 != null) {
                h1 = h1.next;
            }
            if(h2 != null) {
                h2 = h2.next;
            }
        }

        if(jin > 0){
            r.next = new ListNode(jin);
        }
        return rh;
    }

    public static class ListNode{

        int val;

        ListNode next;

        ListNode(int val){
            this.val = val;
        }

    }

    public static int lengthOfLongestSubstring(String s){

        int maxLength = 0;

        String temp = "";
        for(int i =0 ;i < s.length(); i++){

            String t = String.valueOf(s.charAt(i));
            if(!temp.contains(t)){
                temp = temp + t;
                maxLength = Math.max(temp.length(),maxLength);
            }else {
                temp = temp.substring(temp.lastIndexOf(t)+1,temp.length()) + t;
            }

        }
        return maxLength;
    }

}
