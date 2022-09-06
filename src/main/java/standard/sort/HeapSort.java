package standard.sort;

import java.util.Arrays;

/**
 * @Description:堆排序
 * 时间复杂度均为O(nlogn)
 * @Todo: Created by Grady on 2017/10/16.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arra = {3,4,1,2,4,0,2,4,5,7,8,6,7};
        sort(arra);
        System.out.println(Arrays.toString(arra));
    }


    //空间：O(1) 时间： O(NlogN)
    public static void sort(int[] arra){
        if(arra == null || arra.length < 2){
            return;
        }

        // //自上向下 O(NlogN) 构建堆（有无数据都行）
        // for(int i = 0; i < arra.length; i++){
        //     heapInsert(arra, i);
        // }

        //自下向上 O(N) 有数据才行
        for(int i = arra.length -1; i >= 0;i--){
            heapify(arra, i, arra.length);
        }

        int heapSize = arra.length;
        swap(arra, 0, --heapSize);

        while(heapSize > 0){
            heapify(arra, 0, heapSize);
            swap(arra, 0, --heapSize);
        }

    }

    //堆下沉 O(logN)
    private static void heapify(int[] arra,int index,int heapSize){
        int left = index * 2 + 1;
        while(left<heapSize){ //有左孩子
            // 是否有右孩子，有比较，得到较大的
            int largest = left + 1 < heapSize && arra[left +1] > arra[left] ? left +1:left;

            //与父比较大小
            largest = arra[largest] > arra[index] ? largest : index;

            if(largest == index){
                break;
            }

            swap(arra, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    //堆，上浮  O(logN)
    private static void heapInsert(int[] arra , int index){
        while(arra[index] > arra[(index-1)/2]){
            swap(arra, index, (index -1)/2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arra,int src ,int dist){
        arra[src] = arra[src] + arra[dist];
        arra[dist] = arra[src] - arra[dist];
        arra[src] = arra[src] - arra[dist];
    }
}
