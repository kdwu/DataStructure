/**
 * @项目名 liuyubobobo
 * @文件名 LoopQueue.java
 * @作者 geely
 * @创建时间 2021年05月31日 15:58:00
 * @描述 循环队列
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(2 * getCapacity());
        }

        data[tail] = e;
        size++;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E ret = data[front];

        data[front] = null;
        front = (front + 1) % data.length;

        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];

//        for (int i = 0; i < size; i++) {
//            newData[i] = data[(i + front) % data.length];
//        }

        for (int i = front; i != tail; i = (i + 1) % data.length) {
            newData[i] = data[i];
        }

        data = newData;

        //front = 0;
        //tail = size;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>(5);

        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
            System.out.println(queue);
        }

        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

        System.out.println(queue);
    }

}