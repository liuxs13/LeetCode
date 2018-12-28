package liuxs.com.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 401.二进制手表
 * @Auther: liuxs
 * @Date: 2018/12/26 14:09
 * <p>
 * 题目：二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 时：8 4 2 1
 * 分：32 16 8 4 2 1
 * 每个LED灯代表一个0 或 1，最低位在右侧。
 * 例如：时的 1、2 亮，分的1、8、16亮，代表的时间是：3：25
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间？
 * <p>
 * 注意事项：
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”
 * <p>
 * 解题思路：
 * 1、利用回溯算法
 * 2、暴力遍历计算+bitCount统计灯亮的个数
 *
 */
public class ReadBinaryWatch {

    public static void main(String[] args) {
        List<String> result = readBinaryWatch1(2);
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s + ";");
        }
    }

    /**
     * Method1：回溯算法
     * 三要素：
     * 选择：小时/分钟增量
     * 条件：亮灯数量
     * 结束：小时>=12 || 分钟>=60
     *
     * 这里一个很巧妙的设计是，把led灯对应的值存到数组，利用start来确定可使用的值范围。
     */
    public static final int[] led = {1,2,4,8,1,2,4,8,16,32};
    public static List<String> readBinaryWatch1(int num){
        List<String> list = new ArrayList<String>();
        if(num >= 0)
            read_recursion(num, 0, list, 0, 0);
        return list;
    }

    private static void read_recursion(int num, int start, List<String> list, int hour, int minute) {
        if(num <= 0) {
            if(hour < 12 && minute < 60) {
                list.add(String.format("%d:%02d", hour, minute));
            }
        }
        else {
            for(int i = start; i < led.length; i++) {
                if(i < 4)
                    read_recursion(num - 1, i + 1, list, hour + led[i], minute);
                else
                    read_recursion(num - 1, i + 1, list, hour, minute + led[i]);
            }
        }
    }

    /**
     * Method2 暴力遍历计算
     *
     *
     *
     */
    public static List<String> readBinaryWatch2(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++)
//                if (Integer.bitCount(h * 64 + m) == num)
                if (Integer.bitCount(h * 64) + Integer.bitCount(m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }
}
