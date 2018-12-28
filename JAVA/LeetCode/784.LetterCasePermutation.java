package liuxs.com.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 784. 字母大小写全排列
 * @Auther: liuxs
 * @Date: 2018/12/28 16:23
 * <p>
 * 题目要求：给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 分析思路：典型的树状遍历输出，回溯算法解决
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        List<String> res = letterCasePermutation("a1b2");
        for (String re : res) {
            System.out.println(re);
        }
    }

    /**
     * 三要素：
     * 选择：顺序读取字符串
     * 条件：字母变大小写，数字不变
     * 结束：字符串读完
     */
    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return null;
        }
        convert(result, 0, "", s);
        return result;
    }

    public static void convert(List<String> res, int start, String s, String str) {
        if (start >= str.length()) {
            res.add(s);
        } else {
            if (Character.isDigit(str.charAt(start))) {
                convert(res, start + 1, s + Character.toString(str.charAt(start)), str);
            } else {
                convert(res, start + 1, s + Character.toLowerCase(str.charAt(start)), str);
                convert(res, start + 1, s + Character.toUpperCase(str.charAt(start)), str);
            }
        }
    }

}
