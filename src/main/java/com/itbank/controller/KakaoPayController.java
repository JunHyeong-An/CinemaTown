package com.itbank.controller;

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

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class KakaoPayController {

	private ObjectMapper mapper = new ObjectMapper();
	String tid = "";
	@GetMapping("/success")
	public String success(@RequestParam("pg_token") String pgToken, HttpSession session) throws IOException {
		kakaoPayApprove(pgToken, session);
		
		return "redirect:/cinemaMovie/ticketingSuccess";
	}
	
	@PostMapping("/cinemaMovie/kakaoPay/{ticketingJson}/")
	@ResponseBody
	public String kakaoPay(@PathVariable String ticketingJson, HttpSession session) throws IOException {
		System.out.println(ticketingJson);
		HashMap<String, String> kakaoPay = new HashMap<String, String>();
		
		kakaoPay = mapper.readValue(ticketingJson, new TypeReference<HashMap<String,String>>() {});
		session.setAttribute("ticketingJson", ticketingJson);
		
		URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK d143e83dc154401c679ffe64cae1e360");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		String userId = (String) session.getAttribute("userId");
		String movieName = URLEncoder.encode(kakaoPay.get("movieName"), "UTF-8");

		String parameter = "cid=TC0ONETIME&" + "partner_order_id=11111&" + "partner_user_id="+userId+"&"
				+ "item_name="+movieName+"&" + "quantity="+Integer.parseInt(kakaoPay.get("adultCnt"))+Integer.parseInt(kakaoPay.get("studentCnt"))+"&" + "total_amount="+kakaoPay.get("totalCost")+"&" + "tax_free_amount=0&"
				+ "approval_url=http://localhost:8080/cinematown/success&" + "cancel_url=http://localhost:8080/cinematown/cancle&"
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
	
		HashMap<String, String> map = mapper.readValue(buffReader.readLine(), HashMap.class);
		tid = map.get("tid");
		return map.get("next_redirect_pc_url");
	}
	
	public String kakaoPayApprove(String pgToken, HttpSession session) throws IOException {
		URL url = new URL("https://kapi.kakao.com/v1/payment/approve");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK d143e83dc154401c679ffe64cae1e360");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		String userId = (String) session.getAttribute("userId");
		String params = 
				"cid=TC0ONETIME&"
				+ "tid=" + tid + "&"
				+ "partner_order_id=11111&"
				+ "partner_user_id="+userId+"&"
				+ "pg_token=" + pgToken;
		
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		
		dos.writeBytes(params);
		dos.flush();
		dos.close();
		
		Scanner sc = new Scanner(conn.getInputStream());
		String json = "";
		
		if(conn.getResponseCode() == 200) {
			while(sc.hasNext()) {
				json += sc.nextLine();
			}
		}
//		sc.close();
//		conn.disconnect();
		System.out.println("json : " +json);
		
		return json;
	}
}
