public class Exercise4 {
	public static void main(String[] args) {
		int[] a = {1, 2, -3, 4, 5, 4};
		int n= 3;
		windowPosSum(a, n);		
	}

	public static void windowPosSum(int[] numbers, int N) {
		int length= numbers.length;
		for(int i=0;i<length;++i) {
			if(numbers[i] > 0) {
				int temp= 0;
				for(int j=i;j<length&&j<=i+N;++j) {
					temp= temp+numbers[j];
				}
				numbers[i]= temp;
			}
		}
		for(int number: numbers) {
			System.out.print(number+" ");
		}
	}
}