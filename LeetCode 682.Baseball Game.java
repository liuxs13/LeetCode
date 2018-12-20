题目：你现在是棒球比赛记录员。
给定一个字符串列表，每个字符串可以是以下四种类型之一：
1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。

每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
你需要返回你在所有回合中得分的总和。



思路：分析题目要设计找回最多上三次的记录（C+D操作时，会使用到最近三次的数），因此考虑用Stack最为方便。
	较为简单



class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            try {
                stack.push(Integer.valueOf(op));
            } catch (Exception e) {
                if ("C".equals(op)) {
                    stack.pop();
                } else if ("D".equals(op)) {
                    Integer peek = stack.peek();
                    stack.push(2 * peek);
                } else if ("+".equals(op)) {
                    Integer peek = stack.peek();
                    Integer secPeek = stack.size() > 1 ? stack.get(stack.size() - 2) : 0;
                    stack.push(peek + secPeek);
                } else {
                    throw new RuntimeException("illegality input");
                }
            }
        }
        int result = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            result = result + iterator.next();
        }
        return result;
    }
    
}