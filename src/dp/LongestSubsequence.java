package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestSubsequence {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println( lengthOfLIS(nums) );

    }
    public static int lengthOfLIS(int[] nums) {
        if( nums == null ) return -1;

        List<Integer> list = new ArrayList<>();

        int n = nums.length;
        list.add(nums[0]);

        for(int i = 1; i < n; i++){
            int index = Collections.binarySearch(list, nums[i]);
            int end = list.size();
            if( index < 0 ){
                int temp = Math.abs(index);
                if( temp > end ) list.add(nums[i]);
                else{
                    list.set(temp-1, nums[i]);
                }
            }

        }

        return list.size();
    }
}
