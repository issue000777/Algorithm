package geeksforgeeks;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The
 * Next greater Element for an element x is the first greater element on the
 * right side of x in array. Elements for which no greater element exist,
 * consider next greater element as -1.
 *
 */
public class NextGreaterElement {

	public static void main(String[] args) {

		int[] arr = { 4, 5, 2, 3, 10, 7, 25 };
		int element = 10;

		int nge = _getResult(arr, element);
		System.out.println(nge);

	}

	private static int _getResult(int[] arr, int element) {

		int nth = 0;
		while (arr[nth] != element)
			nth++;

		
		int result = -1;
		for (int i = nth + 1; i < arr.length; i++) {
			
			if (arr[i] > element) {

				if (result == -1)
					result = arr[i];

				else if (arr[i] < result)
					result = arr[i];

			}
		}

		return result;
	}

}
