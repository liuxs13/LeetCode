package liuxs.com.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 17. 电话号码的字母组合
 * @Auther: liuxs
 * @Date: 2018/12/28 18:44
 * <p>
 * 题目：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 * <p>
 * 示例：输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 分析思路：还是回溯算法
 * 三要素分析
 * 选择：每个数字对应的字母
 * 条件：有对应字母才加
 * 结束：输入的数字依次读完
 */
public class LetterCombinations {

    public static final String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        List<String> ret = letterCombinations("");
        StringBuilder sb = new StringBuilder("[");
        for (String item : ret) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        System.out.print(sb.toString());
    }

    public static List<String> letterCombinations(String digits) {
        digits = digits.replace("\\\"", "").replace("\"", "");
        List<String> res = new ArrayList<>();
        if (!digits.isEmpty()) {
            helper(res, "", 0, digits);
        } else {
            res.add("");
        }
        return res;
    }

    public static void helper(List<String> res, String s, int start, String digits) {
        if (start >= digits.length()) {
            if (s != null || s.isEmpty()) {
                res.add(s);
            }
        } else {
            int index = Integer.valueOf(digits.substring(start, start + 1));
            if (nums[index].isEmpty()) {
                helper(res, s, start + 1, digits);
            } else {
                for (char c : nums[index].toCharArray()) {
                    String str = Character.toString(c);
                    helper(res, s + str, start + 1, digits);
                }
            }

        }
    }

}
