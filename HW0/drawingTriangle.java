public class drawingTriangle {

	/** Drawing the triangle by the input number */
	public static void main(String[] args) {
		/** Avoid the type error */
		try{
			int num= Integer.parseInt(args[0]);
			for(int i=0;i<num;++i) {
				for(int j=0;j<=i;++j){
					System.out.print("*");
				}
				System.out.println(" ");
			}
		}catch(Exception e) {
			System.out.println("the input is not the type of Integer");
			System.exit(0);
		}
	}
}