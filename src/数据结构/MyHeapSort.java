package 数据结构;

import java.util.Arrays;

public class MyHeapSort {
	public static void main(String[] args) {
		int arr[] = { 6, 7, 5, 4, 3, 2, 1 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		// 初始化无序堆为大小顶堆
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}
		// 交换元素并重新调整堆
		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr,0,i);
			adjustHeap(arr, 0, i);
		}
	}

	private static void swap(int arr[],int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void adjustHeap(int[] arr, int i, int length) {
		int temp = arr[i];
		for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
			if (k + 1 < length && arr[k] < arr[k + 1]) {
				k++;
			}
			// 大顶堆处理
			if (arr[k] > temp) {
				arr[i] = arr[k];
				i = k;
			} else {
				break;
			}
		}
		arr[i] = temp;
	}
}
