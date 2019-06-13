package com.bang.br;

/**
 * Given an array of integers, return indices of the two
 * numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one
 * solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class SolutionTwoSum {

    //方法1
    public int[] towSum(int[] nums, int target){
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++ ){
            for(int j = 1 + i; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        throw new IllegalArgumentException("No two number");
    }

    //方法1
    public int[] towSum2(int[] nums, int target){
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++ ) {
            if (i + 1 == nums.length) {
                continue;
            }
            if (nums[i] + nums[i + 1] == target) {
                res[0] = i;
                res[1] = i + 1;
                return res;
            }
        }

        throw new IllegalArgumentException("No two number");
    }
}
