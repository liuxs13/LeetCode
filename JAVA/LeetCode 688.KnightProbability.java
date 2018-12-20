package liuxs.com.leetCode;

import java.util.Arrays;

/**
 * @Description: 马在棋盘的概率
 * @Auther: liuxs
 * @Date: 2018/12/20 14:49
 * <p>
 * 题目：
 * 已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。
 * 即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。
 * 现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。
 * <p>
 * 分析：分母其实很简单，因为马走的"日"，移动一步有八种走法。移动K步就是 8的K次方。
 * 难点在于分子的计算，两种方法：回溯算法；另一种：算每个格子经过K步留下的概率。
 * <p>
 * 思路1：@knightProbability
 * 利用回溯算法，类似枚举的 深度优先搜索 过程找到问题的解，发现条件不满足时，回溯状态（递归返回），尝试别的路径。
 * 设计三个元素：
 * 选择：
 * 条件：移动K次后，仍在NxN内
 * 结束：移动K次
 * <p>
 * 思路2： @otherMethod
 * 抛弃以初始点开始计算步数的想法，计算棋盘上的点经过K步后仍然在留在棋盘上走法的总和求出来。
 * 其实也是一个递归的累积。以(0,0)为例，第一步迭代时，循环适应steps，将符合条件的格子.val累加，
 * 每个格子都在循环适应steps，记录留在棋盘的走法。第二部迭代时，其实就是把符合条件的格子经过第一个步steps后，记录的走法求和，以此类推。。。
 */
public class KnightProbability {

    private static int[][] steps = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) {
        System.out.println(knightProbability(3, 2, 0, 0));
        System.out.println(otherMethod(3, 2, 0, 0));
    }

    /** 思路1 */
    public static double knightProbability(int N, int K, int r, int c) {
        if (K == 0) {
            return 1.0;
        }
        //
        double[][][] x = new double[K + 1][N + 1][N + 1];
        return helper(N, K, r, c, x);
    }

    private static double helper(int N, int K, int r, int c, double[][][] x) {
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0.0;
        }
        if (K == 0) {
            return 1.0;
        }
        if (x[K][r][c] != 0) {//已计算过该情况，直接返回避免重复
            return x[K][r][c];
        }
        for (int[] step : steps) {
            x[K][r][c] += 0.125 * helper(N, K - 1, r + step[0], c + step[1], x);
        }
        return x[K][r][c];
    }

    /** 思路2 */
    public static double otherMethod(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        for (double[] d : dp) {
            Arrays.fill(d, 1);
        }
        for (int k = 1; k <= K; k++) {
            double[][] t = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] d : steps) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x < 0 || x >= N || y < 0 || y >= N)
                            continue;
                        t[i][j] += dp[x][y];
                    }
                }
            }
            dp = t;
        }
        return dp[r][c] / Math.pow(8, K);
    }

}
