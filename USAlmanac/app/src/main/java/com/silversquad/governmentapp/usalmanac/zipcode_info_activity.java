package com.silversquad.governmentapp.usalmanac;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.XML;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Pradeep Copyright (C) 2017 Pradeep Senthil and Tomas Bindokas. All
 *         rights reserved. This class belongs to the USAlmanac project.
 */
public class zipcode_info_activity extends AppCompatActivity{

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
    public zipcode_info_activity(int zip) {
        zipcode = zip;
        urlToJSON();
        JSONarr = JSON.split("\\r?\\n");
    }

    public zipcode_info_activity(){
        zipcode=0;
        JSONarr = new String[1];
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

            if(conn.getResponseCode() != 200){
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
        } catch (JSONException e){
            JSON = "404 ERROR";
        }


    }

    public String[] getSentateNum1() {
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < JSONarr.length; i++) {
            if (JSONarr[i].contains("national_senator_1")) {
                String temp = JSONarr[i];
                temp = temp.substring(temp.indexOf(" ",20), temp.length() - 2);
                temp = temp.substring(2, temp.length());
                output.add(temp);
            }
        }
        String[] stockArr = new String[output.size()];
        stockArr = output.toArray(stockArr);

        return stockArr;
    }

    public String[] getSentateNum2() {
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < JSONarr.length; i++) {
            if (JSONarr[i].contains("national_senator_2")) {
                String temp = JSONarr[i];
                temp = temp.substring(temp.indexOf(" ",20), temp.length() - 2);
                temp = temp.substring(2, temp.length());
                output.add(temp);
            }		}

        String[] stockArr = new String[output.size()];
        stockArr = output.toArray(stockArr);

        return stockArr;
    }

    public String[] getRep() {
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < JSONarr.length; i++) {
            if (JSONarr[i].contains("representative_1")) {
                String temp = JSONarr[i];
                temp = temp.substring(temp.indexOf(" ",20), temp.length() - 2);
                temp = temp.substring(2, temp.length());
                output.add(temp);			}
        }
        String[] stockArr = new String[output.size()];
        stockArr = output.toArray(stockArr);

        return stockArr;
    }

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

    public String[] getGov() {
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < JSONarr.length; i++) {
            if (JSONarr[i].contains("\"governor")) {
                String temp = JSONarr[i];
                temp = temp.substring(temp.indexOf(" ",20), temp.length() - 2);
                temp = temp.substring(2, temp.length());
                output.add(temp);				}
        }
        String[] stockArr = new String[output.size()];
        stockArr = output.toArray(stockArr);

        return stockArr;
    }

}