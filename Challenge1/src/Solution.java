/*
 * Using the email ID inputed to fetch the name of the person the email ID belong to.
 * 
 * Author Shumeng Guo
 * Version 03/10/19
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Solution {
	
	//default constructor
	public static void main(String[] args) throws IOException {
		GetName();
	}
	
	//getting the email ID and returning the the name of the person the email ID to belong to
	public static void GetName() throws IOException {
		
		//getting the email ID as user input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the email id: ");
		String emailID = reader.readLine();
		
		//getting the data from HTML file located at the given URL
		String webAddress = "https://www.ecs.soton.ac.uk/people/";
		//instantiate an URL object
		URL urlAddress = new URL(webAddress);
		//open a char stream to get the data from the HTML file
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(urlAddress.openStream()));
        String inputLine;
        //check every line in the file for the name until the line is null
        while ((inputLine = dataIn.readLine()) != null)
        	//filter out lines that include the name of the person's name using given conditions
        	if (inputLine.contains("name") && inputLine.contains("/people/" + emailID)) {
        		//returns the name of the person from the fixed position in each line
        		System.out.println(inputLine.substring(61, (inputLine.indexOf("<", 61))));
        	}
        dataIn.close();
	}
}
