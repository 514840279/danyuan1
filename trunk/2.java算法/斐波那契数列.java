import java.util.Scanner;

public class 쳲��������� {
	public static void main(String[] args) {
		int i = 1, j = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ҫ���쳲��������е�ǰ����");
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
