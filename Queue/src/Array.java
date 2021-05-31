/**
 * @项目名 liuyubobobo
 * @文件名 Array.java
 * @作者 geely
 * @创建时间 2021年05月27日 09:57:00
 * @描述 动态数组
 */
public class Array<E> {

    private int size;
    private E[] data;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity 容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return capacity
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组中第index的位置添加元素
     *
     * @param index 位置
     * @param e     元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index >= 0 and index <= size.");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
    }

    /**
     * 向数组的末尾添加元素
     *
     * @param e 要添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组头添加一个元素
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 取出索引为index的元素
     *
     * @param index 索引
     * @return
     */
    E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Index is illegal.");
        }

        return data[index];
    }

    /**
     * 将index位置的元素修改为e
     *
     * @param index 索引
     * @param e     元素
     */
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, Index is illegal.");
        }

        data[index] = e;
    }

    /**
     * 判断数组中是否包含元素e
     *
     * @param e 元素
     * @return 布尔值
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在，则返回-1
     *
     * @param e 元素
     * @return int
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 从数组中删除第index位置的元素，返回删除的元素
     *
     * @param index 索引
     * @return int
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed, Index is illegal.");
        }

        E ret = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        data[size] = null;  // 可以不写

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * 删除数组中最后一个元素
     *
     * @return int
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组中第一个元素
     *
     * @return int
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除第一个找到的元素e
     *
     * @param e 元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 获取数组最后一个元素
     *
     * @return E
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取数组第一个元素
     *
     * @return E
     */
    public E getFirst() {
        return get(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 扩容操作
     *
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }
}
