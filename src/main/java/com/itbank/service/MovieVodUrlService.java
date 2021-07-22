package com.itbank.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MovieVodUrlService {

	private ObjectMapper mapper = new ObjectMapper();
//	@GetMapping("/cinemaMovie/movieVod")
//	public String movieVod() {
//		
//		return "cinemaMovie/movieVod";
//	}
//
//	@GetMapping(value="/cinemaMovie/movieVod/vodUrl",produces = "application/json;charset=utf-8")
//	@ResponseBody
//	public String vodUrl() throws IOException {
//		StringBuilder urlBuilder = new StringBuilder("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&nation=대한민국"); 
//		/*URL*/ 
//		urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=65TF8R843O8851911435"); 
//		/*Service Key*/ 
//		urlBuilder.append("&" + URLEncoder.encode("title","UTF-8") + "=" + URLEncoder.encode("랑종", "UTF-8")); 
////		urlBuilder.append("&" + URLEncoder.encode("releaseDts","UTF-8") + "=" + URLEncoder.encode("20210707", "UTF-8")); 
//		/*상영년도*/ 
//	//	urlBuilder.append("&" + URLEncoder.encode("val002","UTF-8") + "=" + URLEncoder.encode("07", "UTF-8")); 
//		/*상영 월*/ 
//		URL url = new URL(urlBuilder.toString()); 
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
//		conn.setRequestMethod("GET"); 
//		conn.setRequestProperty("Content-type", "application/json"); 
//		conn.setRequestProperty("Accept-Charset", "UTF-8"); 
//		conn.setDoOutput(true);
//		
//		
//		BufferedReader rd; 
//		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) { 
//			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		} 
//		else { 
//			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
//		} 
//		StringBuilder sb = new StringBuilder(); 
//		String line =""; 
//		while ((line = rd.readLine()) != null) { 
//			sb.append(line); 
//		} 
//		rd.close(); 
//		conn.disconnect(); 
//
//		
//		return sb.toString();
//		
//		
//		
//		
//	
//	}
}
