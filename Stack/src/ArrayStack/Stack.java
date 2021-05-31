package ArrayStack;

/**
 * @项目名 liuyubobobo
 * @文件名 Stack.java
 * @作者 geely
 * @创建时间 2021年05月28日 14:26:00
 * @描述 栈的顶层接口
 */
public interface Stack<E> {

    /**
     * 获取栈内的元素个数
     *
     * @return int
     */
    int getSize();

    /**
     * 判断栈是否为空
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 入栈
     *
     * @param e 元素
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return E
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return E
     */
    E peek();
}
