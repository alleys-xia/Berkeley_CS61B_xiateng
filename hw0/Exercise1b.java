import java.util.Scanner;
public class Exercise1b {
	public static void main(String[] args) {
		System.out.print("please input the N: ");
		Scanner sc= new Scanner(System.in);
		int N= sc.nextInt();
		drawTriangle(N);
	}

	public static void drawTriangle(int N) {
		for(int i=0;i<N;++i) {
			for(int j=0;j<=i;++j) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}