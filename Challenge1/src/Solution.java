import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GetName();
	}
	public static void GetName() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the email id: ");
		String emailID = reader.readLine();
		String webAddress = "https://www.ecs.soton.ac.uk/people/";
		URL urlAddress = new URL(webAddress);
		BufferedReader dataIn = new BufferedReader(
		new InputStreamReader(urlAddress.openStream()));
        String inputLine;
        while ((inputLine = dataIn.readLine()) != null)
        	if (inputLine.contains("name") && inputLine.contains("/people/" + emailID)) {
        		System.out.println(inputLine.substring(61, (inputLine.indexOf("<", 61))));
        	}
        dataIn.close();
	}
}
