public class Exercise3 {
	public static void main(String[] args) {
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(numbers)); 
	}

	public static int max(int[] m) {
		int length= m.length;
		int max= -1;
		for(int i= 0;i< length; ++i) {
			if(max < m[i]) {
				max= m[i];
			}
		}
		return max;
	}
}