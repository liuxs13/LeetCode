package liuxs.com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 40. 组合总和 II
 * @Auther: liuxs
 * @Date: 2019/1/8 17:52
 * <p>
 * 题目：给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 思路：其实和 20.组合总和 思路一样，都是用回溯算法。思路点在于解集不能重复，保证排序后，任意相邻的两个数字不重复再做回溯，否则就跳过。
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println("\n-------new-------");
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }

        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> re = new ArrayList<>();
        helper(res, re, candidates, target, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> re, int[] candidates, int target, int num) {
        if (target > 0) {
            for (int i = num; i < candidates.length; i++) {
                //排序后相邻数字比较，相同跳过
                if (i > num && candidates[i] == candidates[i-1])
                    continue;
                List<Integer> list = new ArrayList<>(re);
                list.add(candidates[i]);
                helper(res, list, candidates, target - candidates[i], i + 1);
            }
        } else if (target == 0) {
            res.add(re);
        }
    }

}
