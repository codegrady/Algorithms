package sort;

import java.util.Arrays;

/**
 * @Description:冒泡排序
 * 时间复杂度：最好-O(n)；综合-O(n^2)
 * @Todo: Created by Grady on 2017/10/16.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {12,54,2,64,36,7,97,3,32,37,51,4,9,6,4,222,6};
//        sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.parallelSort(arr,0,arr.length);
        System.out.print(Arrays.toString(arr));
    }


    public static void sort(int[] a)
    {
        int temp;
        for (int i = a.length - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (a[j + 1] < a[j])
                {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;//设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}
