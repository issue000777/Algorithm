package geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumTriplets {

	public static void main(String[] args) {

		//int arr[] = { 0, -1, 2, -3, 1 };
		int arr[] = {1, -2, 1, 0, 5};

		String result = _getResult(arr);
		System.out.println(result);

	}

	private static String _getResult(int[] arr) {

		String result = "";

		Map<Integer, List<String>> cache = new HashMap<Integer, List<String>>();

		for (int i = 0; i < arr.length - 1; i++) {
			cache = new HashMap<Integer, List<String>>();
			for (int j = i + 1; j < arr.length; j++) {

				List<String> getList = cache.get(arr[j] * (-1));
				if (getList != null) {
					for(String str : getList){
						result += str + "," + arr[j] + "\n";
					}
					
				}
				
				
				List<String> cacheList = cache.get((arr[i] + arr[j]));
				if (cacheList == null) {
					cacheList = new ArrayList<String>();
				}
				cacheList.add(arr[i] + "," + arr[j]);
				cache.put(arr[i] + arr[j], cacheList);
			}
		}


		return result;
	}

}
