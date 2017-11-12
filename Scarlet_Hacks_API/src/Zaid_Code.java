import java.util.Scanner;

public class Zaid_Code {
	public static void main(String[] args) {

		Scanner user_input = new Scanner(System.in);
		System.out.println("Type your Zip Code: ");
		int ZipCode = user_input.nextInt();

		Zipcode hi = new Zipcode(ZipCode);

		String[] test1 = hi.getSentateNum1();
		String[] test2 = hi.getSentateNum2();
		String[] test3 = hi.getCounty();
		String[] test4 = hi.getGov();

		for(int i = 0;i<test4.length;i++) {
			System.out.println(test4[i]);
		}
		

	}
	
	

}
