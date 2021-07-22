package com.itbank.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KakaoPayService {

	private ObjectMapper mapper = new ObjectMapper();
	String tid = "";
	
	public String kakaoPayReady(HashMap<String, String> kakaoPay, String userId) throws IOException {
		
		
		URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK d143e83dc154401c679ffe64cae1e360");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		
		String movieName = URLEncoder.encode(kakaoPay.get("movieName"), "UTF-8");
		int peopleCount = Integer.parseInt(kakaoPay.get("adultCnt"))+Integer.parseInt(kakaoPay.get("studentCnt"));

		String parameter = "cid=TC0ONETIME&" + "partner_order_id=11111&" + "partner_user_id="+userId+"&"
				+ "item_name="+movieName+"&" + "quantity="+peopleCount+"&" + "total_amount="+kakaoPay.get("totalCost")+"&" + "tax_free_amount=0&"
				+ "approval_url=http://localhost:8080/cinematown/cinemaMovie/success&" + "cancel_url=http://localhost:8080/cinematown/cancle&"
				+ "fail_url=http://localhost:8080/cinematown/fail";
		OutputStream out = conn.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		dos.writeBytes(parameter);
		dos.close();

		
		int result = conn.getResponseCode();

		InputStream input;
		if (result == 200) {
			input = conn.getInputStream();
		} else {
			input = conn.getErrorStream();
		}
		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader buffReader = new BufferedReader(reader);
		String kakaoPayInfo = buffReader.readLine();
		conn.disconnect();
		
		HashMap<String, String> Info = mapper.readValue(kakaoPayInfo, HashMap.class);
		tid = Info.get("tid");
		return Info.get("next_redirect_pc_url");
		
	}

	public void kakaoPayApprove(String pgToken, String userId) throws IOException {
		URL url = new URL("https://kapi.kakao.com/v1/payment/approve");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK d143e83dc154401c679ffe64cae1e360");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		
		String parameter = 
				"cid=TC0ONETIME&"
				+ "tid=" + tid + "&"
				+ "partner_order_id=11111&"
				+ "partner_user_id="+userId+"&"
				+ "pg_token=" + pgToken;
		
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.writeBytes(parameter);
		dos.close();
		
		int result = conn.getResponseCode();

		InputStream input;
		if (result == 200) {
			input = conn.getInputStream();
		} else {
			input = conn.getErrorStream();
		}
		
		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader buffReader = new BufferedReader(reader);
		String kakaoSuccessInfo = buffReader.readLine();
		conn.disconnect();
		System.out.println(kakaoSuccessInfo);

	}
	
	
	
	
}
