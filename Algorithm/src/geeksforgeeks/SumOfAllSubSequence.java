package geeksforgeeks;

/**
 * Given an array of n integers. The task is to find the sum of sum of each of
 * sub-sequence of the array.
 *
 */
public class SumOfAllSubSequence {

	public static void main(String[] args) {

		//int arr[] = { 6, 8, 5 };
		int arr[] = { 6, 7, 8 };

		int result = _getResult(arr);

		System.out.println(result);

	}

	private static int _getResult(int[] arr) {

		int result = 0;

		for (int i : arr) {
			result += i;
		}

		return (int) (Math.pow(2, arr.length - 1) * result);
	}

}
