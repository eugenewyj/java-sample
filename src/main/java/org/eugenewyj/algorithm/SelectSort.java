package org.eugenewyj.algorithm;

import java.util.Arrays;

/**
 * 选择排序示例
 */
public class SelectSort {
    /**
     * 选择排序
     * @param array 待排序数组
     * @param <T>   数组元素类型
     */
    public <T extends Comparable> void sort(T[] array) {
        int end = array.length;
        for (int i = 0; i < end; i++) {
            for (int j = i+1; j < end; j++) {
                T temp = array[i];
                if (array[j].compareTo(temp) < 0) {
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 7, 2, 10};
        System.out.println("排序前：" + Arrays.toString(arr));
        SelectSort quickSort = new SelectSort();
        quickSort.sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
