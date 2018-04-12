import java.util.Scanner;

public class 斐波那契数列 {
	public static void main(String[] args) {
		int i = 1, j = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("要输出斐波那契数列的前几个");
		int length = sc.nextInt();
		for (int n = 0; n < length; n++) {
			int temp;
			System.out.print(i + " ");
			temp = i + j;
			j = i;
			i = temp;
		}
	}
}
