package geeksforgeeks;

public class ChocolateDistribution {

	public static void main(String[] args) {

		int[] input = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };
		int m = 7;

		System.out.println("Output : " + _getResult(input, m));

	}

	static private int _getResult(int[] input, int m) {
		int result = input[input.length - 1] - input[0];
		_quickSort(input, 0, input.length - 1);

		for (int i = 0; i + m <= input.length; i++) {
			if (input[i + m - 1] - input[i] < result) {
				result = input[i + m - 1] - input[i];

			}
		}

		return result;
	}

	static private void _quickSort(int[] input, int start, int end) {

		if (start >= end)
			return;

		int pivot = input[end];
		int m = 0;
		int n = 0;

		int[] tmp = new int[end + 1];

		for (int i = start; i < end; i++) {
			if (input[i] < pivot) {
				tmp[start + m++] = input[i];
			} else {
				tmp[end - n++] = input[i];
			}
		}
		tmp[start+m] = pivot;

		for (int i = start; i <= end; i++) {
			input[i] = tmp[i];
		}
		
		

		_quickSort(input, start, start + m - 1);
		_quickSort(input, start + m + 1, end);
	}

}
