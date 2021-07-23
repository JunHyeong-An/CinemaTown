package com.itbank.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class MovieVodUrlService {

	public String vodUrl(String movieName) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&nation=대한민국"); 
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=65TF8R843O8851911435");
		urlBuilder.append("&" + URLEncoder.encode("title","UTF-8") + "=" + URLEncoder.encode(movieName, "UTF-8")); 

		URL url = new URL(urlBuilder.toString()); 
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
		conn.setRequestMethod("GET"); 
		conn.setRequestProperty("Content-type", "application/json"); 
		conn.setRequestProperty("Accept-Charset", "UTF-8"); 
		conn.setDoOutput(true);
		
		
		BufferedReader rd; 
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) { 
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} 
		else { 
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
		} 
		StringBuilder sb = new StringBuilder(); 
		String line =""; 
		while ((line = rd.readLine()) != null) { 
			sb.append(line); 
		} 
		rd.close(); 
		conn.disconnect(); 

		
		return sb.toString();
		
		
		
		
	
	}
}
