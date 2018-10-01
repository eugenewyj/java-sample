package org.eugenewyj.algorithm;


import java.util.Arrays;

/**
 * 快速排序算法示例
 */
public class QuickSort {
    /**
     * 快速排序算法
     * @param arr 待排序数组
     * @param <T> 数组中元素类型
     * @return 排序后数组
     */
    public <T extends Comparable> void sort(T[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivotIndex = begin;
        T pivot = arr[pivotIndex];
        for (int i = begin+1; i <= end; i++) {
            T temp = arr[i];
            if (pivot.compareTo(temp) > 0) {
                arr[i] = pivot;
                arr[pivotIndex] = temp;
                pivotIndex = i;
            }
        }
        sort(arr, begin, pivotIndex-1);
        sort(arr, pivotIndex+1, end);
    }


    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 7, 2, 10};
        System.out.println("排序前：" + Arrays.toString(arr));
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length-1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
