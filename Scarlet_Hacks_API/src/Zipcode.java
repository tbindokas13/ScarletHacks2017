import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import org.json.XML;

/**
 * 
 * @author Pradeep Copyright (C) 2017 Pradeep Senthil and Tomas Bindokas. All
 *         rights reserved. This class belongs to the USAlmanac project.
 */
public class Zipcode {

	/**
	 * Stores the zipcode for instance of class created.
	 */
	public int zipcode = 0;

	/**
	 * Stores the JSON string format.
	 */
	public String JSON = "";

	/**
	 * Splits the main string into an array seperated by new line.
	 */
	public String[] JSONarr;

	/**
	 * Constructor for zipcode class.
	 * 
	 * @param zip
	 *            enters the zipcode into the application.
	 */
	public Zipcode(int zip) {
		zipcode = zip;
		urlToJSON();
		JSONarr = JSON.split("\\r?\\n");
	}

	/**
	 * This function takes the zipcode entered by the user and returns a string of
	 * the data in JSON format. The data received form the database is in XML
	 * format, the function also converts XML to JSON.
	 * 
	 * @return String JSON file retrieved form API Call.
	 */
	public void urlToJSON() {
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
			JSON = XML.toJSONObject(output).toString(4);

		} catch (MalformedURLException e) {
			e.printStackTrace();
			JSON = "404 ERROR";
		} catch (IOException e) {
			e.printStackTrace();
			JSON = "404 ERROR";
		}
	}
	
	/**
	 * Code to get Senator #1 from state.
	 * @return Array with all information relating to Senator #1 from Zip Code.
	 */
	public String[] getSentateNum1() {
		ArrayList<String> output = new ArrayList<String>();
		for (int i = 0; i < JSONarr.length; i++) {
			if (JSONarr[i].contains("national_senator_1")) {
				String temp = JSONarr[i];
				temp = temp.substring(temp.indexOf(" ", 19), temp.length() - 2);
				temp = temp.substring(2, temp.length());
				output.add(temp);
			}
		}
		String[] stockArr = new String[output.size()];
		stockArr = output.toArray(stockArr);

		return stockArr;
	}

	/**
	 * Code to gte Senator #2 from state.
	 * @return Array with all information relating to Senator #2 from Zip Code
	 */
	public String[] getSentateNum2() {
		ArrayList<String> output = new ArrayList<String>();
		for (int i = 0; i < JSONarr.length; i++) {
			if (JSONarr[i].contains("national_senator_2")) {
				String temp = JSONarr[i];
				temp = temp.substring(temp.indexOf(" ", 19), temp.length() - 2);
				temp = temp.substring(2, temp.length());
				output.add(temp);			}
		}
		String[] stockArr = new String[output.size()];
		stockArr = output.toArray(stockArr);

		return stockArr;
	}

	/**
	 * Code to get Rep from selected zip code relative to county.
	 * @return Array with all information relating to rep from given zip code.
	 */
	public String[] getRep() {
		ArrayList<String> output = new ArrayList<String>();
		for (int i = 0; i < JSONarr.length; i++) {
			if (JSONarr[i].contains("representative_1")) {
				String temp = JSONarr[i];
				temp = temp.substring(temp.indexOf(" ", 19), temp.length() - 2);
				temp = temp.substring(2, temp.length());
				output.add(temp);			}
		}
		String[] stockArr = new String[output.size()];
		stockArr = output.toArray(stockArr);

		return stockArr;
	}

	/**
	 * Gives county form which zipcode is from.
	 * @return County
	 */
	public String[] getCounty() {
		ArrayList<String> output = new ArrayList<String>();
		for (int i = 0; i < JSONarr.length; i++) {
			if (JSONarr[i].contains("county_name")) {
				String temp = JSONarr[i];
				temp = temp.substring(temp.indexOf(" ", 19), temp.length()-1);
				temp = temp.substring(2, temp.length());
				output.add(temp);			}
		}
		String[] stockArr = new String[output.size()];
		stockArr = output.toArray(stockArr);

		return stockArr;
	}
	
	/**
	 * Gives all info regarding the governor 
	 * @return All info relating to the govenor from zip code. 
	 */
	public String[] getGov() {
		ArrayList<String> output = new ArrayList<String>();
		for (int i = 0; i < JSONarr.length; i++) {
			if (JSONarr[i].contains("\"governor")) {
				String temp = JSONarr[i];
				temp = temp.substring(temp.indexOf(" ", 19), temp.length() - 2);
				temp = temp.substring(2, temp.length());
				output.add(temp);			}
		}
		String[] stockArr = new String[output.size()];
		stockArr = output.toArray(stockArr);

		return stockArr;
	}

}
