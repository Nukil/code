package sort;

import utils.ArrayUtils;

import java.util.PriorityQueue;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        int num = 300000;
        int[] array = new int[num];
        Random rand = new Random();
        for (int i = 0; i < num; ++i) {
            array[i] = rand.nextInt(1000000);
        }

        System.out.println("Before heap:");
//        ArrayUtils.printArray(array);

        long t1 = System.currentTimeMillis();
        heapSort(array);
        System.out.println(System.currentTimeMillis() - t1);

        System.out.println("After heap sort:");
//        ArrayUtils.printArray(array);
    }

    public static void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        buildMaxHeap(array);

        for (int i = array.length - 1; i >= 1; i--) {
            ArrayUtils.exchangeElements(array, 0, i);

            maxHeap(array, i, 0);
        }
    }

    private static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int half = array.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    private static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (index != largest) {
            ArrayUtils.exchangeElements(array, index, largest);

            maxHeap(array, heapSize, largest);
        }
    }
}
