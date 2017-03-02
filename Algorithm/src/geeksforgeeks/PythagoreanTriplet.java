package geeksforgeeks;

import java.util.Arrays;

/**
 * Given an array of integers, write a function that returns true if there is a
 * triplet (a, b, c) that satisfies a^2 + b^2 = c^2
 *
 */
public class PythagoreanTriplet {

	public static void main(String[] args) {

		// int arr[] = { 3, 1, 4, 6, 5 };
		// int[] arr = {10, 4, 6, 12, 5};
		int[] arr = { 14, 17, 13, 15, 19, 10, 3, 16, 9, 12 };
		//int[] arr = { 9, 3, 10};

		boolean result = _getResult(arr);

		System.out.println(result);

	}

	private static boolean _getResult(int[] arr) {

		_sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

		/*
		 * Square every element
		 */
		for (int i = 0; i < arr.length; i++)
			arr[i] = arr[i] * arr[i];

		for (int pivot = arr.length - 1; pivot >= 2; pivot--) {

			int L = 0;
			int R = pivot - 1;

			while (L < R) {

				int tmp = arr[L] + arr[R] - arr[pivot];

				if (tmp == 0) {
					return true;
				}

				else if (tmp > 0) {
					R--;
				}

				else {
					L++;
				}

			}

		}

		return false;

	}

	private static void _sort(int[] arr, int start, int end) {

		if (start >= end)
			return;

		int pivot = end;
		int L = start;
		int R = end-1;

		while (L <= R) {

			if (arr[L] < arr[pivot]) {
				L++;
				continue;
			}

			if (arr[R] > arr[pivot]) {
				R--;
				continue;
			}
			int tmp = arr[R];
			arr[R] = arr[L];
			arr[L] = tmp;
			L++;
			R--;

		}
		int tmp = arr[L];
		arr[L] = arr[pivot];
		arr[pivot] = tmp;
		pivot = L;
		
		_sort(arr, start, pivot - 1);
		_sort(arr, pivot + 1, end);

	}

}
