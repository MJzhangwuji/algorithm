package com.zhangwuji.algorithm.arrays;

/**
 * @author zhangwuji
 * @date 2021/7/28  --19:06
 */

import sun.applet.Main;

import java.util.HashMap;
import java.util.Map;

/**
 * 求解 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target 
 * 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。
 * 但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class TwoSums {
    //方法一:穷举两数组的所有情况
    public static int[] twoSum1(int[] nums, int target) {
        int nlength = nums.length;
        for (int i = 0; i < nlength - 1; i++) {
            for (int j = i + 1; j < nlength; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        throw new IllegalArgumentException("no solutions");

    }



    //方法二:使用hashmap来存储结果
    public int[] twoSum2(int[] nums, int target) {

        //第一步将数组当中的数和下标存入到hashmap当中,
        int nlength = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nlength; i++) {
            map.put(nums[i], i);
        }
        //第二步判断hash表中key值是否拥有当前所求数 设置数-当前数.,
        for (int i = 0; i < nums.length; i++) {
            int thatNum = target - nums[i];
            if (map.containsKey(thatNum) && nums[i] != i) {
                return new int[]{i, map.get(thatNum)};
            }
        }
        throw new IllegalArgumentException("no solutions!");
    }

    //方法三:优化使用hashmap来存储结果
    //优化成一次循环,在第一次循环当中直接存入到哈希表中,节省一次0(n)的时间复杂度
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //循环求解每个数组中是否有所求值
            int thatNum = target - nums[i];
            if (map.containsKey(thatNum)){

                return new int[]{map.get(i),nums[i]};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solutions");
    }


    public static void main(String[] args) {
        int input[] = {3, 4, 5, 6};
        int target = 9;
        long startTime = System.currentTimeMillis();
        TwoSums TS = new TwoSums();
        int[] ints = TS.twoSum(input, target);
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms");
    }
}