package liuxs.com.leetCode;

import java.util.Arrays;

/**
 * @Description: 136. 只出现一次的数字
 * @Auther: liuxs
 * @Date: 2019/1/11 17:05
 *
 * 题目：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 思路分析：用0分别于num按位异或
 *
 * 按位异或特点：
 * 1、0异或任何数 = 任何数
 * 2、1异或任何数 = 任何数±1
 * 3、任何数异或自己 = 0
 */
public class SingleNumber {

    public static void main(String[] args) {

        int[] nums = {14,11,12,11,12};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int num = 0;
        for (int i : nums) {
            System.out.println("num.bin:" + Integer.toBinaryString(num) + "^ i.bin:" + Integer.toBinaryString(i));
            num = num ^ i;
            System.out.println("result:" + Integer.toBinaryString(num));
        }
        return num;
    }
}
