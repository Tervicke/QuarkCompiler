import java.util.Scanner;
public class io{
	public static void main(String[] args){
		int x = readInt();
		System.out.println(x);
	}
	public static int readInt(){
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		return input;
	}
}
