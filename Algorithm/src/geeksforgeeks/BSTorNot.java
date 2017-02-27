package geeksforgeeks;

public class BSTorNot {

	public static void main(String[] args) {

		int val[] = {10, 40, 50, 70};
	    int wt[] = {1, 3, 4, 5};
	    int  w = 8;

		int result = _getResult(w, val, wt);
		System.out.println(result);
	}

	static int _getResult(int w, int[] val, int[] wt) {
		int[] result = new int[w + 1];

		for (int i = 1; i <= w; i++) {
			int maxValue = 0;

			for (int k = 0; k < val.length; k++) {
				int value = 0;
				

				if (wt[k] <= i)
					value = result[i - wt[k]] + val[k];
//				else
//					value = val[k];
				
				if (maxValue < value)
					maxValue = value;
			}
			result[i] = maxValue;

		}
		
		for (int i = 1; i <= w; i++) {
			System.out.println(i + " : " + result[i]);
		}

		return result[w];
	}

}
