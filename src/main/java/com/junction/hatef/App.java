package com.junction.hatef;

/**
 * Main application for dealing with API represented by Varian Imaging!
 *
 */

import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/*  1.for handling a response (HttpResponse),
    2.assigning JSON-type to it (JsonNode),
    3.and making a GET request (Unirest),
    4.URLEncoder for preparing params to be sent.*/


public class App
{
    public static void main( String[] args ) throws Exception
    {
      String host = "https://junction-planreview.azurewebsites.net/api/patients";
      String query = "";
	  HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
												.asJson();
	  // show the response status and content type
	  System.out.println("Status: " + response.getStatus());
	  System.out.println(response.getHeaders().get("Content-Type"));
  
  
	  //Prettifying the received single-line json response
	  Gson gson = new GsonBuilder().setPrettyPrinting().create();
	  JsonParser jp = new JsonParser();
	  JsonElement je = jp.parse(response.getBody().toString());
	  String prettyJsonString = gson.toJson(je);
	  System.out.println(prettyJsonString);
    }
}
