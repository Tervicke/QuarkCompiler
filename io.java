import java.util.Scanner;
public class io {
	public static void main(String[] args){
	}
	public static int readInt() {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		return input;
	}
	public static double readDouble() {
		Scanner sc = new Scanner(System.in);
		double input = sc.nextDouble();
		return input;
	}
	public static String readString(){
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		return input;
	}
	public static String readLine(){
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		return input;
	}
}
