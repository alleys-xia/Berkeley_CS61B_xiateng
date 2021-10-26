public class Exercise2 {
	public static void main(String[] args) {
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(numbers)); 
	}

	public static int max(int[] m) {
		int length= m.length;
		int i=0;
		int max= -1;
		while(i<length) {
			if(max < m[i]) {
				max= m[i];
			}
			i++;
		}
		return max;
	}
}