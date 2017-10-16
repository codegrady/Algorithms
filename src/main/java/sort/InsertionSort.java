package sort;

/**
 * @Description:插入排序 时间复杂度均为O(n^2)
 * @Todo: Created by Grady on 2017/10/16.
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }
}
