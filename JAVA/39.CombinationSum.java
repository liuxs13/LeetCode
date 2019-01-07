package liuxs.com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 39. 组合总和
 * @Auther: liuxs
 * @Date: 2019/1/7 16:43
 *
 * 题目：给定一个无重复元素的数组 candidates 和一个目标数 target ，
 *      找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        //排序
        Arrays.sort(candidates);
        List<List<Integer>> lists = combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println("\n-------new-------");
                System.out.print(integer + ",");
            }

        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> is = new ArrayList<>();
        helper(is, res, candidates, target, 0);
        return res;
    }

    public static void helper(List<Integer> is, List<List<Integer>> res, int[] candidates, int target, int num) {
        if (sumList(is) == target) {
            res.add(is);
        }
        if (sumList(is) > target) return;
        for (int i = num; i < candidates.length; i++) {
            if (sumList(is) < target) {
                List<Integer> list = new ArrayList<>(is);
                list.add(candidates[i]);
                helper(list, res, candidates, target, i);
            }

        }
    }

    public static Integer sumList(List<Integer> list) {
        Integer i = 0;
        for (Integer integer : list) {
            i += integer;
        }
        return i;
    }


}
