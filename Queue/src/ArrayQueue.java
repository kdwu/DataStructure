/**
 * @项目名 liuyubobobo
 * @文件名 ArrayQueue.java
 * @作者 geely
 * @创建时间 2021年05月31日 15:05:00
 * @描述 数组队列
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enQueue(E e) {
        array.addLast(e);
    }

    @Override
    public E deQueue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(" ,");
            }
        }
        res.append("]  tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);

            System.out.println(queue);
        }

        queue.deQueue();
        System.out.println(queue);

        queue.deQueue();
        System.out.println(queue);

        queue.deQueue();
        System.out.println(queue);
    }
}
