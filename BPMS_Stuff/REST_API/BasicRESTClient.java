package org.sample.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//import org.apache.commons.codec.binary.Base64;
import org.switchyard.common.codec.Base64;



public class BasicRESTClient {

	public static void main(String[] args) {
		new BasicRESTClient().startInstance();
	}
	
	
	
	public void startInstance(){
		
		  try {

				URL url = new URL("http://localhost:8280/business-central/rest/runtime/org.sample:LabProject:1.0/process/SimpleProject.IncrementAge2/start?map_name=Rick&map_age=10");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				/**
				Base64 aBase64 = new Base64();
				byte[] encoded = aBase64.encodeBase64(encodeThis);
				String encodedStr = new String(encoded);
				**/
				
				String encodeThisStr = "erics:bpmsuite1!";
				byte[] encodeThis = encodeThisStr.getBytes();
				String encodedStr = Base64.encode(encodeThis);
				System.out.println("encodedStr:" + encodedStr);
				conn.setRequestProperty("Authorization", "Basic " + encodedStr);

				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");

				OutputStream os = conn.getOutputStream();
				os.flush();

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			 }
		
		
		
	}

}
