package ArrayStack;

/**
 * @项目名 liuyubobobo
 * @文件名 Test.java
 * @作者 geely
 * @创建时间 2021年05月28日 14:44:00
 * @描述 测试类
 */
public class Test {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
