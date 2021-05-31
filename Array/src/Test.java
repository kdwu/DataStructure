/**
 * @项目名 liuyubobobo
 * @文件名 Test.java
 * @作者 geely
 * @创建时间 2021年05月27日 10:24:00
 * @描述 测试类
 */
public class Test {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();

        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
