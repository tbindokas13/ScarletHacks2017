import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.XML;

/**
 * 
 * @author Pradeep Copyright (C) 2017 Pradeep Senthil and Tomas Bindokas. All rights reserved. 
 * This class belongs to the USAlmanac project.
 */
public class Zipcode {

	/**
	 * Stores the zipcode for instance of class created.
	 */
	public int zipcode = 0;

	/**
	 * Constructor for zipcode class.
	 * 
	 * @param zip enters the zipcode into the application.
	 */
	public Zipcode(int zip) {
		zipcode = zip;
	}

	/**
	 * This function takes the zipcode entered by the user and returns a string of the data in JSON format.
	 * The data received form the database is in XML format, the function also converts XML to JSON.
	 * 
	 * @return String JSON file retrieved form API Call.
	 */
	public String urlToJSON() {
		try {
			String mainURL = "https://usgeocoder.com/api/get_info.php?zipcode=" + Integer.toString(zipcode)
					+ "&authkey=f4bbfda269405c5a27e0a87bc6868b1a";
			URL url = new URL(mainURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = "";
			String a;
			while ((a = br.readLine()) != null) {
				output += a + "\n";
			}
			conn.disconnect();
			return XML.toJSONObject(output).toString(4);

		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "404 ERROR";
		} catch (IOException e) {
			e.printStackTrace();
			return "404 ERROR";
		}
	}

}
