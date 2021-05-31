package leetcode_20;


import ArrayStack.ArrayStack;

/**
 * @项目名 liuyubobobo
 * @文件名 Solution.java
 * @作者 geely
 * @创建时间 2021年05月28日 14:50:00
 * @描述 leetcode 第20题 有效的括号
 */
class Solution {

    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        ArrayStack<Character> stack = new ArrayStack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (c == ']' && stack.pop() != '[') {
                    return false;
                }

                if (c == '}' && stack.pop() != '{') {
                    return false;
                }

                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }


    public boolean isValid2(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        ArrayStack<Character> stack = new ArrayStack<Character>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("([)]"));
    }

}
