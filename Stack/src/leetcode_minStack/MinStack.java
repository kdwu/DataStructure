package leetcode_minStack;

import java.util.Stack;

/**
 * @项目名 liuyubobobo
 * @文件名 MinStack.java
 * @作者 geely
 * @创建时间 2021年05月28日 16:23:00
 * @描述 找出栈中的最小值
 */
class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> minData;

    public MinStack() {
        data = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (minData.isEmpty() || x <= minData.peek()) {
            minData.push(x);
        }
    }

    public void pop() {
        int top = data.pop();
        if (minData.peek() == top) {
            minData.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        if (!minData.isEmpty()) {
            return minData.peek();
        }
        return 0;
    }
}