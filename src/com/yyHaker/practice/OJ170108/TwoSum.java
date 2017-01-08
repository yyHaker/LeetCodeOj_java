package com.yyHaker.practice.OJ170108;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 *
 * @author Le Yuan
 * @date 2017/1/8
 */
public class TwoSum {
    public static void main(String[] args){
       int []digits={3,2,4};
        int []indices=twoSum(digits,6);
        System.out.println("["+indices[0]+","+indices[1]+"]");
    }

    public static int[] twoSum(int[] nums, int target) {
        int indices[]=new int[2];
        for (int i=0;i<=nums.length-1;i++){
            for (int j=i+1;j<=nums.length-1;j++){
                if (nums[i]+nums[j]==target){
                     indices[0]=i;
                     indices[1]=j;
                    return indices;
                }
            }
        }
        return null;
    }


    /**
     * 使用hash表，时间复杂度为O(n),扫描两遍hashTable
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_useHashMap_1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
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

    /**
     * 使用hash表，时间复杂度为O(n),扫描一遍hashTable
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_useHashMap_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
