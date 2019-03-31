package com.easycode.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String arg[]) {
        int[] arrays1 = twoNumsum1(new int[]{3,3}, 6);
        /*Arrays.asList(arrays).forEach(x -> {
            System.out.println(x);
        });*/

        for (int i : arrays1) {
            System.out.print(i);
            System.out.print(" ");
        }
        ;
    }

    public static int[] twoNumSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoNumsum1(int[] nums, int target) {

        Map<String, Integer> result = new HashMap<String, Integer>();
        for (int i = 0; i < nums.length; i++) {

            String key1 = ""+(target - nums[i]);
            if( nums[i] != target - nums[i]) {
                result.put(key1, i);
            }else {
                if(!result.containsKey(key1)){
                    result.put(key1, i);
                }else {
                    result.put("a"+key1, i);
                }

            }
        }

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] != target - nums[i]) {
                String key1 = (target - nums[i]) + "";
                String key2 = nums[i] + "";
                if (result.containsKey(key1)
                        && result.containsKey(key2)) {
                    return new int[]{result.get(key1), result.get(key2)};
                }
            }else {
                String key1 = (target - nums[i]) + "";
                String key2 = "a"+key1;
                if (result.containsKey(key1)
                        && result.containsKey(key2)) {
                    return new int[]{result.get(key1), result.get(key2)};
                }
            }
        }

        return new int[]{};

    }

}
