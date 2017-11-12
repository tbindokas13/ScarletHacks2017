import java.util.Scanner;


public class Zaid_Code
{
	public static void main(String[] args)
	{
		
	Scanner user_input = new Scanner(System.in);
	System.out.println("Type your Zip Code: ");
	int ZipCode = user_input.nextInt();
    Data_Retriever number = new Data_Retriever();
    number.GetZipCode(ZipCode);
    
	}

}
