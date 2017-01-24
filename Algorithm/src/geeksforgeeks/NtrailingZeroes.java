package geeksforgeeks;

public class NtrailingZeroes {

	public static void main(String[] args) {

		
		int input = 4;
		
		System.out.println(_getResult(input));
		
	}
	
	static private int _getResult(int n){
		
		int twoNum = 0;
		int fiveNum = 0;
		
		int i = 1;
		while(true){
			int tmp = i;
			
			while(tmp % 2 == 0){
				tmp = tmp/2;
				twoNum++;
			}
			
			while(tmp % 5 == 0){
				tmp = tmp/5;
				fiveNum++;
			}
			
			if(twoNum >= n && fiveNum >= n){
				return i;
			}
			
				
			i++;
		}
		

	}

}
