package liuxs.com.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 22. 括号生成
 * @Auther: liuxs
 * @Date: 2019/1/4 18:10
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 解题思路：回溯算法，非常典型
 * 三要素：选择：一般是由多个if或for构成，优先放左括号  条件：if条件  结束：左右括号用完
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        if (n < 1)
            return null;
        helper(n, n, "", res);
        return res;

    }

    public static void helper(int l, int r, String re, List<String> res) {
        if (l == 0 && r == 0)
            res.add(re);
        if (l > 0)
            helper(l-1, r, re+"(", res);
        if (r > l)
            helper(l, r-1, re+")",res);
    }
}
