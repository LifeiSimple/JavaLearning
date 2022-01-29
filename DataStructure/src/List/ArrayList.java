package List;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> {
    private Object[] arr = new Object[16];
    private int size = 0;

    /**
     * 获取表的长度
     *
     * @return 顺序表的长度
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 添加一个元素
     *
     * @param e     元素
     * @param index 要添加的位置(索引)，下标从0开始
     */
    @Override
    public void add(E e, int index) {
        if (index > size || index < 0) throw new IllegalArgumentException("非法的插入位置"); // 检查位置是否合法
        if (size >= arr.length) {   // 扩容
            Object[] new_arr = new Object[this.arr.length * 2];
            for (int i = 0; i < this.arr.length; i++) new_arr[i] = this.arr[i];
            this.arr = new_arr;
        }
        int i = size - 1;
        while (i >= index) {    // 后移元素
            arr[i + 1] = arr[i];
            i--;
        }
        arr[index] = e; // 插入元素
        size++;
    }

    /**
     * 移除指定位置的元素
     *
     * @param index 位置
     * @return 移除的元素
     */
    @Override
    public E remove(int index) {
        if (index > size - 1 || index < 0) throw new IllegalArgumentException("非法的删除位置");
        int i = index;
        E e = (E) arr[index];
        while (i < size -1) {
            arr[i] = arr[i+1];
            i++;
        }
        size--;
        return e;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 位置
     * @return 元素
     */
    @Override
    public E get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("无法访问下标位置");
        return (E) arr[index];
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
}
