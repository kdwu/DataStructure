/**
 * @项目名 liuyubobobo
 * @文件名 Queue.java
 * @作者 geely
 * @创建时间 2021年05月31日 15:00:00
 * @描述 队列顶层接口
 */
public interface Queue<E> {

    /**
     * 获取队列中元素的个数
     *
     * @return int
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 入队
     *
     * @param e 元素
     */
    void enQueue(E e);

    /**
     * 出队
     *
     * @return E
     */
    E deQueue();

    /**
     * 查看队首元素
     *
     * @return E
     */
    E getFront();
}
