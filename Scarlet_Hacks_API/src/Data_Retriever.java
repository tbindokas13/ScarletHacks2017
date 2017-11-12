/**
 * 
 * @author Tomas Copyright (C) 2017 Pradeep Senthil and Tomas Bindokas. All rights reserved. This
 *         class belongs to the USAlmanac project.
 */
public class Data_Retriever 
{
	String Data="";
	public void GetZipCode(int ZipCode) 
	{
		Zipcode getZipCode = new Zipcode(ZipCode);
		Data= getZipCode.urlToJSON();
		System.out.println(Data);
	}
}
